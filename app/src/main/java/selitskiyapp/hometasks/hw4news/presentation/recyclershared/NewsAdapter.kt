package selitskiyapp.hometasks.hw4news.presentation.recyclershared

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import selitskiyapp.hometasks.hw4news.domain.OnNewsClickListener
import selitskiyapp.hometasks.hw4news.presentation.models.News

class NewsAdapter(
    private val itemClickListener: OnNewsClickListener
) : RecyclerView.Adapter<NewsViewHolder>() {
    private var items: List<News> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : NewsViewHolder = NewsViewHolder.from(parent, itemClickListener)

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<News>) {
        items = data
        notifyDataSetChanged()
    }
}