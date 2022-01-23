package selitskiyapp.hometasks.hw4news.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.android.viewmodel.ext.android.viewModel
import selitskiyapp.hometasks.hw4news.R
import selitskiyapp.hometasks.hw4news.databinding.FragmentNewsDAOBinding
import selitskiyapp.hometasks.hw4news.domain.OnNewsClickListener
import selitskiyapp.hometasks.hw4news.presentation.recyclernetwork.NewsAdapter
import selitskiyapp.hometasks.hw4news.presentation.viewmodel.NewsDaoViewModel
import selitskiyapp.hometasks.hw4news.presentation.viewmodel.NewsViewModel

class NewsDAOFragment : Fragment(R.layout.fragment_news_d_a_o) {
    private val binding: FragmentNewsDAOBinding
    by viewBinding(FragmentNewsDAOBinding::bind)
    private val viewModel: NewsDaoViewModel by viewModel()
    private val adapter by lazy { NewsAdapter(newsClickListener) }

    private val newsClickListener: OnNewsClickListener = object : OnNewsClickListener {
        override fun onIconClickListener(position: Int) {
//            viewModel.onNewsItemClicked(position)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_d_a_o, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        initObservers()
    }

    private fun initObservers() {
        viewModel.daoNews.observe(this) { news ->
            adapter.submitList(news)
        }
    }

    private fun initRecycler() {
        binding.recycler.adapter = adapter
    }
}