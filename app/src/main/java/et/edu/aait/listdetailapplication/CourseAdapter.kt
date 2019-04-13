package et.edu.aait.listdetailapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class CourseAdapter(val context: Context):RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private val courses = listOf(

        Course("Software Engineering II", "ITSE-3212",7,"Software Engineering II description"),
        Course("Advanced Mobile Programming", "ITSE-3223",7,"Advanced Mobile Programming description"),
        Course("Operating System", "ITSE-3253",7,"Operating System description")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val recyclerViewItem = inflater.inflate(R.layout.recycler_view_item, parent, false)

        recyclerViewItem.setOnClickListener {

            val courseDetailIntent = Intent(context, CourseDetailActivity::class.java)
             // Extract the code text part of the clicked course
            val courseCode = it.list_code_textview.text
            // Extract the full course information from the courses list using the courseCode
            val course = courses.find { it.code == courseCode }
            // Pass the course detail information to the intent
            if(course != null) {
                courseDetailIntent.putExtra("code", course.code)
                courseDetailIntent.putExtra("title", course.title)
                courseDetailIntent.putExtra("ects", course.ects)
                courseDetailIntent.putExtra("description", course.description)
            }

            context.startActivity(courseDetailIntent)
        }

        return CourseViewHolder(recyclerViewItem)
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.itemView.list_code_textview.text = course.code
        holder.itemView.list_title_textview.text = course.title
    }

    class CourseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}





