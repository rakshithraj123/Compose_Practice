package com.app.investcalculator.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.app.investcalculator.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    // Background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF8A2BE2), // Adjust color for top gradient
                    Color(0xFF00BFFF)  // Adjust color for bottom gradient
                )
            ))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Email Field
            var email by remember { mutableStateOf("") }
            var isEmailValid by remember { mutableStateOf(true) }
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.email_icon),
                        contentDescription = null,
                        tint = Color.Gray
                    )
                },
                trailingIcon = {
                    if (isEmailValid) {
                        Icon(
                            painter = painterResource(id = R.drawable.check_mark),
                            contentDescription = null,
                            tint = Color.Green
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50)),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Password Field
            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50)),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Login Button
            Button(
                onClick = { /* Handle login */ },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6A5ACD) // Adjust button color
                )
            ) {
                Text(text = "Login", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            // Forgot Password
            Text(
                text = "Forgot your password?",
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Or connect with
            Text(
                text = "or connect with",
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Social Buttons
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(top = 16.dp)
            ) {
                SocialButton(text = "Facebook", color = Color(0xFF3b5998))
                Spacer(modifier = Modifier.width(16.dp))
                SocialButton(text = "Twitter", color = Color(0xFF1DA1F2))
            }

            // Sign Up
            Text(
                text = "Don't have an account? Sign up",
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun SocialButton(text: String, color: Color) {
    Button(
        onClick = { /* Handle social login */ },
        modifier = Modifier
            .height(48.dp)
            .clip(RoundedCornerShape(50)),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(text = text, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    SearchScreen()
}