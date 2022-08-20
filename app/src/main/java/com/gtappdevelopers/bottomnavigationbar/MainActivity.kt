package com.gtappdevelopers.bottomnavigationbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem
import np.com.susanthapa.curved_bottom_navigation.CurvedBottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        val accountFragment = AccountFragment()
        val settingsFragment = SettingsFragment()
        val menuItems = arrayOf(
            CbnMenuItem(
                R.drawable.ic_home, R.drawable.avd_anim_home
            ),
            CbnMenuItem(
                R.drawable.ic_account, R.drawable.avd_anim_account
            ),
            CbnMenuItem(
                R.drawable.ic_settings, R.drawable.avd_anim_settings
            ),
        )

        this.supportFragmentManager.beginTransaction().replace(R.id.idFLFragment, accountFragment)
            .commit()
        setCurrentFragment(homeFragment)
        val bottomNavigationView: CurvedBottomNavigationView = findViewById(R.id.idCVBottomNav)
        bottomNavigationView.setMenuItems(menuItems)
        bottomNavigationView.setOnMenuItemClickListener { cbnMenuItem, i ->
            when (i) {
                0 -> setCurrentFragment(homeFragment)
                1 -> setCurrentFragment(accountFragment)
                2 -> setCurrentFragment(settingsFragment)
            }
        }

//        bottomNavigationView.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_item_home -> setCurrentFragment(homeFragment)
//                R.id.nav_item_account -> setCurrentFragment(accountFragment)
//                R.id.nav_item_settings -> setCurrentFragment(settingsFragment)
//            }
//            true
//        }


    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().replace(R.id.idFLFragment, fragment).commit()
}