package com.example.rolodex.model

import androidx.annotation.DrawableRes

/*
image, name, phone number, email (optional)
 */
data class Contact(val fullName:String,
                   var phoneNumber:String,
                   var email:String = "",
                   @DrawableRes var image:Int = 0)
