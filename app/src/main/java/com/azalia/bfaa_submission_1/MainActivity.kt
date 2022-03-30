package com.azalia.bfaa_submission_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.azalia.bfaa_submission_1.data.UserDataDummy
import com.azalia.bfaa_submission_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val userAdapter = UserAdapter()
        userAdapter.setAllData(UserDataDummy.listOfUser(this))

        mainBinding.rvListUser.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }
}