package com.raion.myapplication

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.raion.myapplication.di.AppModule
import com.raion.myapplication.di.ViewModelModule
import com.raion.myapplication.ui.theme.SalingJagaTheme
import com.raion.myapplication.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SalingJagaTheme(darkTheme = false) {
                val navController = rememberNavController()
                AppContent(navController = navController)
            }
        }
    }
}

class MainApplication:Application(){
    override fun onCreate() {
        super.onCreate()

        // Start Dependency Injection
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(AppModule, ViewModelModule))
        }
    }
}