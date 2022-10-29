package com.raion.myapplication.data

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay

class AppRepository constructor(
    private val context: Context,
    private val firestoreDb: FirebaseFirestore,
    private val relatimeDb: FirebaseDatabase,
    private val auth: FirebaseAuth
) {
    // CHECK if user is logged in
    fun userLoggedIn() = auth.currentUser != null

    // Login with email password
    fun loginWithEmailPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailed: () -> Unit
    ) {
        auth
            .signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailed() }
    }

    // Register with email password
    fun registerWithEmailPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailed: () -> Unit
    ) {
        auth
            .createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                loginWithEmailPassword(email, password, onSuccess, onFailed)
            }
            .addOnFailureListener { onFailed() }
    }

    // Logout
    suspend fun logout(onSuccess: () -> Unit){
        auth.signOut()
        delay(1000)
        onSuccess()
    }
}