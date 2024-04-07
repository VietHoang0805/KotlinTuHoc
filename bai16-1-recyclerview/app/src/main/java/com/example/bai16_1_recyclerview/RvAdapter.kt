import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bai16_1_recyclerview.OutData
import com.example.bai16_1_recyclerview.databinding.LayoutItemBinding

class RvAdapter(private val ds: List<OutData>) : RecyclerView.Adapter<RvAdapter.PhimViewHolder>() {

    inner class PhimViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhimViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhimViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhimViewHolder, position: Int) {
        val item = ds[position]
        holder.binding.apply {
            txtMieuTa.text = item.mieuta
            txtTenPhim.text = item.tenPhim
            imgPhim.setImageResource(item.image)
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}
