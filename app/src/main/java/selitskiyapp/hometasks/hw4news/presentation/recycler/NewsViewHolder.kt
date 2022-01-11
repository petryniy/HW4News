package selitskiyapp.hometasks.hw4news.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import selitskiyapp.hometasks.hw4news.databinding.FragmentNewsItemBinding
import selitskiyapp.hometasks.hw4news.network.Article
import selitskiyapp.hometasks.hw4news.presentation.domain.OnNewsClickListener

class NewsViewHolder(
    private val binding: FragmentNewsItemBinding,
    private val itemClickListener: OnNewsClickListener
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup, itemClickListener: OnNewsClickListener): NewsViewHolder {
            return NewsViewHolder(
                FragmentNewsItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                ),
                itemClickListener
            )
        }
    }

    fun bindView(item: Article) = with(binding) {
        title.text = item.title
        checkBox.isChecked = item.isChecked

        loadImageByUrl(item.url)

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