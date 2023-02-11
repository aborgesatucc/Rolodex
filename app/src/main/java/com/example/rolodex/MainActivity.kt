package com.example.rolodex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rolodex.data.Datasource
import com.example.rolodex.model.Contact
import com.example.rolodex.ui.theme.RolodexTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RolodexApp()
        }
    }
}

@Composable
fun RolodexApp() {
    RolodexTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            ContactList(contactList = Datasource().loadContacts())
        }
    }
}

@Composable
fun ContactCard(contact: Contact,
                modifier: Modifier = Modifier) {

    Card (
        modifier = Modifier.padding(10.dp),
        contentColor = Color.Blue) {

        //Image(painter = painterResource(id = contact.image),
        //    contentDescription = "Image of " + contact.fullName)
        Column {

            Text(text = contact.fullName)
            Text(text = contact.email)
            Text(text = contact.phoneNumber)

        }
    }

}

@Composable
fun ContactList(contactList: List<Contact>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(contactList) { contact ->
            ContactCard(contact)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RolodexApp()
}