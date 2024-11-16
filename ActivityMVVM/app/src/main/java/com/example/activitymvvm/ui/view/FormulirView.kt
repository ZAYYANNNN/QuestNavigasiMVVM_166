package com.example.activitymvvm.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormulirView(
    modifier: Modifier = Modifier,
    pilihanJk: List<String>,
    onClickButton: (MutableList<String>) -> Unit
) {

    var nama by remember { mutableStateOf("") }
    var NIM by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nama, jenisK, alamat, NIM, email, noHp)





    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier .padding(20.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama")
            },
            placeholder = {
                Text("Masukkan Nama Anda")
            }
        )
        Spacer(modifier = Modifier .padding(20.dp))

        Row (modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            pilihanJk.forEach { selectedJK ->
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(5.dp))
                {
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("Email")
            },
            placeholder = {
                Text("Masukkan Email Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = noHp,
            onValueChange = {noHp = it},
            label = { Text("No HP")
            },
            placeholder = {
                Text("Masukkan No HP Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat")
            },
            placeholder = {
                Text("Masukkan Alamat Anda")
            }
        )

        Button(onClick = {
            onClickButton(listData)
        },
            modifier = Modifier
                .padding(vertical = 10.dp )) {
            Text("Simpan")
        }


    }
}
