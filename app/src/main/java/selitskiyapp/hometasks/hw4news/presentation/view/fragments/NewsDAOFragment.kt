package selitskiyapp.hometasks.hw4news.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import selitskiyapp.hometasks.hw4news.R
import selitskiyapp.hometasks.hw4news.databinding.FragmentNewsDAOBinding
import selitskiyapp.hometasks.hw4news.domain.OnNewsClickListener
import selitskiyapp.hometasks.hw4news.presentation.recyclershared.NewsAdapter
import selitskiyapp.hometasks.hw4news.presentation.viewmodels.NewsSharedViewModel

class NewsDAOFragment : Fragment(R.layout.fragment_news_d_a_o) {
    private val binding: FragmentNewsDAOBinding
    by viewBinding(FragmentNewsDAOBinding::bind)
    private val sharedViewModel: NewsSharedViewModel by sharedViewModel()
    private val adapter by lazy { NewsAdapter(newsClickListener) }

    private val newsClickListener: OnNewsClickListener = object : OnNewsClickListener {
        override fun onIconClickListener(position: Int) {
            sharedViewModel.onNewsItemClicked(position)

            if (!sharedViewModel.daoNews.value!![position].isChecked) {
                sharedViewModel.deleteDataNews(sharedViewModel.daoNews.value!![position])
            }
        }
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

        sharedViewModel.loadDataNews()
    }

    private fun initObservers() {
        sharedViewModel.daoNews.observe(viewLifecycleOwner) { news ->
            adapter.submitList(news)
        }
    }

    private fun initRecycler() {
        binding.recycler.adapter = adapter
    }
}