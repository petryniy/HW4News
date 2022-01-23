package selitskiyapp.hometasks.hw4news.presentation.recyclernetwork

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import selitskiyapp.hometasks.hw4news.databinding.FragmentNewsItemBinding
import selitskiyapp.hometasks.hw4news.domain.OnNewsClickListener
import selitskiyapp.hometasks.hw4news.presentation.objects.News

class NewsViewHolder(
    private val binding: FragmentNewsItemBinding,
    private val itemClickListener: OnNewsClickListener
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup, itemClickListener: OnNewsClickListener): NewsViewHolder {
            return NewsViewHolder(
                FragmentNewsItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false),
                itemClickListener
            )
        }
    }

    fun bindView(item: News) = with(binding) {
        title.text = item.title
        checkBox.isChecked = item.isChecked

        item.urlToImage?.let { loadImageByUrl(it) }

        checkBox.setOnClickListener {
            itemClickListener.onIconClickListener(bindingAdapterPosition)
        }
    }

    private fun loadImageByUrl(url: String) = with(binding) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}