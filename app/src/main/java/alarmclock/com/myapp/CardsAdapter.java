package alarmclock.com.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder> {

private ArrayList<String> arrayList;

    public CardsAdapter(ArrayList<String> arrayList) {this.arrayList = arrayList;}

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView)LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        return new CardViewHolder(cv);

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardView cv=holder.cv;
        TextView definitionText=cv.findViewById(R.id.txtDefinition);
        definitionText.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
       return arrayList.size();
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;

        public CardViewHolder(@NonNull CardView cv) {
            super(cv);
            this.cv = cv;
        }
    }


}
