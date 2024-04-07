import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bai16_3_recyclerview.databinding.LayoutItemBinding

class RvAdapter(private val ds: List<Int>) : RecyclerView.Adapter<RvAdapter.itemViewHolder>() {

    class itemViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return itemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.binding.apply {
            imgAnh.setImageResource(ds[position])
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}
