package selitskiyapp.hometasks.hw4news.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import selitskiyapp.hometasks.hw4news.network.Article
import selitskiyapp.hometasks.hw4news.presentation.domain.OnNewsClickListener

class NewsAdapter(
    private val itemClickListener: OnNewsClickListener
) : RecyclerView.Adapter<NewsViewHolder>() {
    private var items: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : NewsViewHolder = NewsViewHolder.from(parent, itemClickListener)

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<Article>) {
        items = data
        notifyDataSetChanged()
    }
}