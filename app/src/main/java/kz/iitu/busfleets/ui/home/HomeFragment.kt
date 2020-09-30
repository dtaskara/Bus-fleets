package kz.iitu.busfleets.ui.home

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kz.iitu.busfleets.R
import kz.iitu.busfleets.models.Item
import kz.iitu.busfleets.ui.adapters.ItemsAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        list_view.layoutManager = LinearLayoutManager(activity)
        setupViews();
    }

    private fun setupViews() {


        val items: List<Item> = listOf<Item>(
            Item(1, "Almaty", "Astana", "25.09.2020", "25.10.2020", "name", "522", 45),
            Item(2, "Almaty", "Astana", "25.09.2020", "25.10.2020", "name", "522", 45),
            Item(3, "Almaty", "Astana", "25.09.2020", "25.10.2020", "name", "522", 45),
            Item(4, "Almaty", "Astana", "25.09.2020", "25.10.2020", "name", "522", 45),
            Item(5, "Almaty", "Astana", "25.09.2020", "25.10.2020", "name", "522", 45),
            Item(6, "Almaty", "Astana", "25.09.2020", "25.10.2020", "name", "522", 45)
        );

        list_view.adapter = ItemsAdapter(items, onItemClick = {

        },
            deleteItem = {
                var id = 0;
                var c = 0;
                for (item in items) {

                    if (item.id == it.id) {
                        id = c;
                        break
                    }
                    c++;
                }
                items.drop(id);


            }
        )

    }


}