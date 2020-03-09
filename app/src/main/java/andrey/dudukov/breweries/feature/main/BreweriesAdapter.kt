package andrey.dudukov.breweries.feature.main

import andrey.dudukov.breweries.R
import andrey.dudukov.breweries.core.base.adapter.BaseAdapter
import andrey.dudukov.breweries.entity.Brewery
import andrey.dudukov.breweries.utils.extension.*
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_breweries.view.*

class BreweriesAdapter : BaseAdapter<Brewery, BreweriesAdapter.BreweriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweriesViewHolder {
        val view = parent.inflate(R.layout.item_breweries)
        return BreweriesViewHolder(view)
    }

    class BreweriesViewHolder(itemView: View) : BaseViewHolder<Brewery>(itemView) {

        override fun bind(item: Brewery, position: Int) {
            with(itemView) {
                tvName.text = item.name
                tvStreetValue.setIfNotEmpty(item.street, gStreet)
                tvCityValue.setIfNotEmpty(item.city, gCity)
                tvStateValue.setIfNotEmpty(item.state, gState)
                tvCountryValue.setIfNotEmpty(item.country, gCountry)
                tvPhoneValue.setIfNotEmpty(item.phone, gPhone)
                tvWebUrlValue.setIfNotEmpty(item.websiteUrl, gWebUrl)
                tvWebUrlValue.underline()
                if (item.latitude.isNotEmpty() && item.longitude.isNotEmpty()) btnShowOnMap.visible() else btnShowOnMap.gone()
            }
        }
    }
}