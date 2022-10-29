package com.raion.myapplication.screen

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.preference.PreferenceManager
import android.provider.Settings
import android.view.LayoutInflater
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.raion.myapplication.R
import com.raion.myapplication.component.AppButtonField
import com.raion.myapplication.component.AppTopBar
import com.raion.myapplication.component.AppTopBarNoContent
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.ui.theme.BlueDark
import com.raion.myapplication.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    /**Attrs*/
    val permission = rememberPermissionState(permission = android.Manifest.permission.ACCESS_FINE_LOCATION)
    val viewModel = getViewModel<HomeViewModel>()
    val context = LocalContext.current
    val appSettingIntent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.parse("package:" + context.getPackageName())
    )

    /**Function*/
    if (viewModel.showLocationPermissionDeniedRationale.value) {
        AlertDialog(
            onDismissRequest = { /*TODO*/ },
            buttons = {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Pastikan anda telah mengizinkan akses lokasi pada aplikasi De Montir",
                        textAlign = TextAlign.Center
                    )
                    AppButtonField(
                        onClick = { permission.launchPermissionRequest() }
                    ) {
                        Text(text = "Izinkan", color = Color.White)
                    }
                }
            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        )
    }
    if (viewModel.showLocationPermissionDeniedNotRationale.value) {
        AlertDialog(
            onDismissRequest = { /*TODO*/ },
            buttons = {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Sepertinya sengaja/tidak sengaja, anda telah menolak permintaan izin lokasi. " +
                                "\nUntuk melanjutkan, anda harus mengizinkan akses lokasi secara manual di pengaturan",
                        textAlign = TextAlign.Center
                    )
                    AppButtonField(
                        onClick = {
                            context.startActivity(appSettingIntent)
                        }) {
                        Text(text = "Buka Pengaturan", color = Color.White)
                    }
                }

            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        )
    }
    when(permission.status){
        is PermissionStatus.Denied -> {
            if (permission.status.shouldShowRationale) {
                viewModel.showLocationPermissionDeniedNotRationale.value = false
                viewModel.showLocationPermissionDeniedRationale.value = true
            } else {
                viewModel.showLocationPermissionDeniedRationale.value = false
                viewModel.showLocationPermissionDeniedNotRationale.value = true
            }
        }
        PermissionStatus.Granted -> {
            viewModel.showLocationPermissionDeniedRationale.value = false
            viewModel.showLocationPermissionDeniedNotRationale.value = false
        }
    }

    /**Content*/
    Scaffold(
        topBar = {
            AppTopBarNoContent(title = "SalingJaga")
        }
    ) {
        HomeContent(navController = navController)
    }
}

@Composable
private fun HomeContent(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background (MAP)
        val myContext = LocalContext.current
        val provider = GpsMyLocationProvider(myContext)
        Configuration.getInstance().load(
            myContext, PreferenceManager.getDefaultSharedPreferences(myContext)
        )
        AndroidView(
            factory = { context ->
                val view =
                    LayoutInflater.from(context).inflate(R.layout.layout_map, null, false)
                val mapView = view.findViewById<MapView>(R.id.mapview)
                val mapController = mapView.controller
                val startPoint = GeoPoint(-7.959, 112.609) //Should change later
                val locationOverlay = MyLocationNewOverlay(provider, mapView)
                locationOverlay.apply {
                    enableMyLocation()
                    enableFollowLocation()
                }
                val marker = Marker(mapView)

                marker.apply {
                    position = startPoint
                    setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
                    icon = context.resources.getDrawable(R.drawable.ic_map_marker, null)
                }

                mapController.apply {
                    setZoom(18.0)
                    setCenter(startPoint)
                }

                mapView.apply {
                    applicationWindowToken
                    setMultiTouchControls(true)
                    setBuiltInZoomControls(false)
//                    overlays.add(marker)
                    overlays.add(locationOverlay)
                    setTileSource(TileSourceFactory.MAPNIK)
                }

                view
            },
            update = { view ->
                val mapView = view.findViewById<MapView>(R.id.mapview)

                mapView.apply {
                    applicationWindowToken
                    setTileSource(TileSourceFactory.MAPNIK)
                }
            }
        )

        // Foreground
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
            // Profile Pic
            Box(modifier = Modifier.padding(16.dp)) {
                AsyncImage(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .clickable {
                            /*TODO Navigate to Profile Screen*/
                        },
                    model = R.drawable.ic_profile_pic,
                    contentDescription = "ProfilePic"
                )
            }

            // All the Button
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.CenterEnd) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Damkar
                    AppButtonField(
                        shape = RoundedCornerShape(8.dp),
                        onClick = { navController.navigate(route = AppNavRoute.RumahSakitScreen.name) },
                        borderColor = Color.LightGray,
                        borderWidth = 1.dp,
                        backgroundColor = BlueDark
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            AsyncImage(modifier = Modifier.width(42.dp), model = R.drawable.ic_ambulance, contentDescription = "Icon")

//                            Text(text = "Ambulan", color = Color.White)
                        }
                    }

                    // Polisi
                    AppButtonField(
                        shape = RoundedCornerShape(8.dp),
                        onClick = { navController.navigate(route = AppNavRoute.PolisiScreen.name) },
                        borderColor = Color.LightGray,
                        borderWidth = 1.dp,
                        backgroundColor = BlueDark
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            AsyncImage(modifier = Modifier.width(42.dp), model = R.drawable.ic_police, contentDescription = "Icon")

//                            Text(text = "Polisi", color = Color.White)
                        }
                    }

                    // Ambulans
                    AppButtonField(
                        shape = RoundedCornerShape(8.dp),
                        onClick = { navController.navigate(route = AppNavRoute.DamkarScreen.name) },
                        borderColor = Color.LightGray,
                        borderWidth = 1.dp,
                        backgroundColor = BlueDark
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            AsyncImage(modifier = Modifier.width(42.dp), model = R.drawable.ic_damkar, contentDescription = "Icon")

//                            Text(text = "Damkar", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}