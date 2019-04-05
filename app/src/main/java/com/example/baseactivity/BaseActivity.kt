package com.example.baseactivity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_base.view.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*
import kotlinx.android.synthetic.main.layout_toolbar_back.view.*

abstract class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var mTextViewScreenTitle: TextView
    lateinit var mProgressDialog: ProgressDialog
    lateinit var mDrawerLayout: DrawerLayout
    lateinit var mNavigationView: NavigationView
    lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mProgressDialog = ProgressDialog(this)
        mProgressDialog.setMessage("Loading")
        mProgressDialog.setCancelable(false)
        mProgressDialog.isIndeterminate = true
    }

    override fun setContentView(layoutResID: Int) {

        mDrawerLayout = layoutInflater.inflate(R.layout.activity_base, null) as DrawerLayout
        val activityContainer: FrameLayout = mDrawerLayout.layout_container
        mTextViewScreenTitle = mDrawerLayout.text_screen_title
        mNavigationView = mDrawerLayout.navigation_view
        mToolbar = mDrawerLayout.toolbar

        val toggle = object : ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {}
        toggle.syncState()

        mDrawerLayout.addDrawerListener(toggle)
        mDrawerLayout.closeDrawer(GravityCompat.START)

        mNavigationView.setNavigationItemSelectedListener(this)

        layoutInflater.inflate(layoutResID, activityContainer, true)

        super.setContentView(mDrawerLayout)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {

        when (p0.itemId) {

            R.id.first -> {
                startActivity(Intent(this, Main2Activity::class.java))
                raiseToast("1st")
                mDrawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.second -> {
                finish()
                raiseToast("2nd")
                mDrawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.third -> {

                raiseToast("3rd")
                mDrawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.fourth -> {

                raiseToast("4th")
                mDrawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.fifth -> {

                raiseToast("5th")
                mDrawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.sixth -> {
                startActivity(Intent(this, Main2Activity::class.java))
                raiseToast("6th")
                mDrawerLayout.closeDrawer(GravityCompat.START)
            }

        }


        return true
    }

    fun raiseToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


    fun setScreenTitle(resId: Int) {
        mTextViewScreenTitle.text = getString(resId)
    }

    fun setScreenTitle(title: String) {
        mTextViewScreenTitle.text = title
    }

    fun showProgressDialog() {
        if (!mProgressDialog.isShowing) {
            mProgressDialog.show()
        }
    }

    fun dismissProgressDialog() {
        if (mProgressDialog.isShowing) {
            mProgressDialog.dismiss()
        }
    }


}