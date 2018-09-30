package `in`.androidbytes.fadein

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(grid) {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = GridAdapter()
            setHasFixedSize(true)
        }
    }
}
