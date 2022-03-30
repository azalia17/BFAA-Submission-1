package com.azalia.bfaa_submission_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azalia.bfaa_submission_1.databinding.ActivityDetailBinding
import com.azalia.bfaa_submission_1.model.User
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USER = "EXTRA_USER"
    }

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER)

        detailBinding.apply {
            tvTotalRepo.text = user?.repository
            tvTotalFollower.text = user?.follower
            tvTotalFollowing.text = user?.following
            tvNameDetail.text = user?.name
            tvUsernameDetail.text = user?.username
            tvCompanyDetail.text = user?.company
            tvLocationDetail.text = user?.location
        }

        Glide.with(this)
            .load(user?.avatar)
            .apply(RequestOptions.circleCropTransform())
            .into(detailBinding.ivAvatar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = user?.name
            elevation = 0f
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}