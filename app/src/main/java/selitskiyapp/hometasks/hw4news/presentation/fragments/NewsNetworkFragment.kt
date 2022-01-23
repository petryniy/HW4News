package selitskiyapp.hometasks.hw4news.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.android.viewmodel.ext.android.viewModel
import selitskiyapp.hometasks.hw4news.R
import selitskiyapp.hometasks.hw4news.databinding.FragmentNewsNetworkBinding
import selitskiyapp.hometasks.hw4news.domain.OnNewsClickListener
import selitskiyapp.hometasks.hw4news.presentation.recyclernetwork.NewsAdapter
import selitskiyapp.hometasks.hw4news.presentation.viewmodel.NewsViewModel

class NewsNetworkFragment : Fragment(R.layout.fragment_news_network) {
    private val binding: FragmentNewsNetworkBinding
            by viewBinding(FragmentNewsNetworkBinding::bind)
    private val viewModel: NewsViewModel by viewModel()
    private val adapter by lazy { NewsAdapter(newsClickListener) }

    private val newsClickListener: OnNewsClickListener = object : OnNewsClickListener {
        override fun onIconClickListener(position: Int) {
            viewModel.onNewsItemClicked(position)

            if(viewModel.news.value!![position].isChecked) {
            viewModel.insertToDataNews(viewModel.news.value!![position])
            } else {
                viewModel.deleteDataNews(viewModel.news.value?.get(position)!!.title)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_network, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        initObservers()

        viewModel.loadNetworkNews()
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