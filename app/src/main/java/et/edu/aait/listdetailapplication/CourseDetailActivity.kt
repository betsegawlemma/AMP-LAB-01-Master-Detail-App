package et.edu.aait.listdetailapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_course_detail.*

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        detail_title_tv.text = intent.getStringExtra("title")
        detail_code_tv.text = intent.getStringExtra("code")
        detail_ects_tv.text = intent.getIntExtra("ects",7).toString()
        detail_description_tv.text = intent.getStringExtra("description")
    }
}
