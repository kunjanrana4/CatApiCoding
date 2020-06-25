package com.example.catapicoding
import Breed
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout.VERTICAL
import android.widget.Toast
import androidx.recyclerview.widget.*
import com.example.catapicoding.adapter.BreedAdapter
import com.example.catapicoding.network.BreedApiService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import kotlinx.android.synthetic.main.fragment_breed.*

class BreedFragment : Fragment() {
    lateinit var breedAdapter: BreedAdapter
    lateinit var recyclerView : RecyclerView
    var disposable: Disposable? = null
    val getApiService by lazy {
        BreedApiService.create()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image, container, false)
        recyclerView = view.findViewById(R.id.recycler_breed)
        val layoutManager = LinearLayoutManager(context)
        //layoutManager.orientation = GridLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        /*disposable = getApiService.getAllBreeds()
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result -> setRecyclerView(result!!,view) }, { error -> showError(error.message) })*/
        return view
    }

    private fun showError(message: String?) {
        Toast.makeText(context,message, Toast.LENGTH_LONG).show()
    }
    private fun setRecyclerView(items:List<Breed>,view:View){
        breedAdapter = BreedAdapter(items)
        recyclerView.adapter = breedAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
    }
}