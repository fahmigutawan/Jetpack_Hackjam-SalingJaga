package com.raion.myapplication.screen

import android.graphics.BitmapFactory
import android.preference.PreferenceManager
import android.view.LayoutInflater
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.raion.myapplication.R
import com.raion.myapplication.component.AppButtonField
import com.raion.myapplication.component.AppTopBar
import com.raion.myapplication.component.AppTopBarNoContent
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.ui.theme.BlueDark
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

@Composable
fun HomeScreen(
    navController: NavController
) {
    /**Attrs*/

    /**Function*/

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