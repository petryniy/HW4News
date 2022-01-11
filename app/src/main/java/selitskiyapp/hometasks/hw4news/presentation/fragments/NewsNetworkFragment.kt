package selitskiyapp.hometasks.hw4news.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import selitskiyapp.hometasks.hw4news.R
import selitskiyapp.hometasks.hw4news.databinding.FragmentNewsBinding
import selitskiyapp.hometasks.hw4news.presentation.domain.OnNewsClickListener
import selitskiyapp.hometasks.hw4news.presentation.recycler.NewsAdapter
import selitskiyapp.hometasks.hw4news.presentation.viewmodel.NewsViewModel

class NewsFragment : Fragment(R.layout.fragment_news) {
    private val binding: FragmentNewsBinding
            by viewBinding(FragmentNewsBinding::bind)
    private val viewModel: NewsViewModel by viewModel()
    private val adapter by lazy { NewsAdapter(newsClickListener) }

    companion object {

    }

    private val newsClickListener: OnNewsClickListener = object : OnNewsClickListener {
        override fun onIconClickListener(position: Int) {
            viewModel.onNewsItemClicked(position)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        initObservers()
    }

    private fun initObservers() {
        viewModel.news.observe(this) { news ->
            adapter.submitList(news)

        }
    }

    private fun initRecycler() {
        binding.recycler.adapter = adapter
    }


}