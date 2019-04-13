package et.edu.aait.listdetailapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class CourseAdapter(context: Context):RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private val courses = listOf(

        Course("Software Engineering II", "ITSE-3212",7,"Software Engineering II description"),
        Course("Advanced Mobile Programming", "ITSE-3223",7,"Advanced Mobile Programming description"),
        Course("Operating System", "ITSE-3253",7,"Operating System description")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val recyclerViewItem = inflater.inflate(R.layout.recycler_view_item, parent, false)

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





