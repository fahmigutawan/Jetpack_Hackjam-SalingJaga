package com.raion.myapplication

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.raion.myapplication.component.AppBottomBar
import com.raion.myapplication.di.AppModule
import com.raion.myapplication.di.ViewModelModule
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.ui.theme.SalingJagaTheme
import com.raion.myapplication.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.compose.getViewModel
import org.koin.core.context.startKoin

lateinit var snackbarListener: @Composable (text: String, state: MutableState<Boolean>) -> Unit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SalingJagaTheme(darkTheme = false) {
                /**Attrs*/
                val navController = rememberNavController()
                val mainViewModel = getViewModel<MainViewModel>()
                val scaffoldState = rememberScaffoldState()
                snackbarListener = { text, state ->
                    if (state.value) {
                        LaunchedEffect(key1 = true) {
                            val snackbarHost = scaffoldState.snackbarHostState

                            val result = snackbarHost.showSnackbar(
                                message = text,
                                duration = SnackbarDuration.Short,
                                actionLabel = "Tutup"
                            )

                            when (result) {
                                SnackbarResult.Dismissed -> state.value = false
                                SnackbarResult.ActionPerformed -> state.value = false
                            }
                        }
                    }
                }

                /**Function*/
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    when (destination.route) {
                        AppNavRoute.HomeScreen.name -> {
                            mainViewModel.showBottomBar = true
                            mainViewModel.recentBottomBarRoute = destination.route ?: ""
                        }

                        AppNavRoute.ProfileScreen.name -> {
                            mainViewModel.showBottomBar = true
                            mainViewModel.recentBottomBarRoute = destination.route ?: ""
                        }

                        else -> {
                            mainViewModel.showBottomBar = false
                            mainViewModel.recentBottomBarRoute = destination.route ?: ""
                        }
                    }
                }

                /**Content*/
                Scaffold(
                    scaffoldState = scaffoldState,
                    bottomBar = {
                        if (mainViewModel.showBottomBar){
                            AppBottomBar(
                                mainViewModel = mainViewModel,
                                navController = navController
                            )
                        }
                    },
                    floatingActionButton = {
                        if (mainViewModel.showBottomBar) {
                            FloatingActionButton(
                                onClick = { /*TODO*/ },
                                backgroundColor = Color.Red,
                                shape = CircleShape
                            ) { Text(text = "SOS", color = Color.White) }
                        }
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButtonPosition = FabPosition.Center
                ) {
                    Box(modifier = Modifier.fillMaxSize().padding(it)){
                        AppContent(navController = navController, mainViewModel = mainViewModel)
                    }
                }
            }
        }
    }
}

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Dependency Injection
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(AppModule, ViewModelModule))
        }
    }
}