package selitskiyapp.hometasks.hw4news

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite -> {
                findNavController(R.id.fragment_container)
                    .navigate(R.id.to_newsDAOFragment)
            }
            R.id.news -> {
                if (R.id.fragment_container.equals(R.id.news)) {

                } else {
                findNavController(R.id.fragment_container)
                    .navigate(R.id.to_newsFragment)}
            }
        }
        return true
    }

}