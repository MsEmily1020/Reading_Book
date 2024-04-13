package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Contact(var name: String, var phone: String) {}

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_activity)

        val contacts = mutableListOf<Contact>()
        for(i in 1..100) {
            contacts.add(Contact("아무개 ${i}", "010-1234-0${i.toString().padStart(3, '0')}"))
        }

        val contactList = findViewById<RecyclerView>(R.id.contact_list)

        // RecyclerView가 고정된 사이즈를 가진다고 알려주는 함수
        // 내부적으로 Size를 측정하여 자신의 Size를 결정하고 이는 비용이 많이 드는 작업이다.

        contactList.setHasFixedSize(true)
        contactList.layoutManager = LinearLayoutManager(this)
        contactList.adapter = ContactListAdapter(contacts)
    }
}