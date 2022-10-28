package com.raion.myapplication.data

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class AppRepository constructor(
    private val context:Context,
    private val firestoreDb:FirebaseFirestore,
    private val relatimeDb:FirebaseDatabase,
    private val auth:FirebaseAuth
) {
    // CHECK if user is logged in
    fun userLoggedIn() = auth.currentUser != null
}