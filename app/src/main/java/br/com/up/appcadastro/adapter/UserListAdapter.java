package br.com.up.appcadastro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.up.appcadastro.R;
import br.com.up.appcadastro.model.User;

public class UserListAdapter
        extends
        RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private ArrayList<User> users;
    private OnUserClickListener listener;

    public UserListAdapter(ArrayList<User> users,
                           OnUserClickListener listener){
        this.users = users;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());

        View layout =
                layoutInflater.inflate(R.layout.view_user,
                        parent,
                        false);

        UserViewHolder userViewHolder =
                new UserViewHolder(layout);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder,
                                 int position) {

        User user = users.get(position);

        TextView textViewFirstName = holder.itemView.
                findViewById(R.id.text_user_first_name);

        TextView textViewSurName = holder.itemView.
                findViewById(R.id.text_user_sur_name);

        TextView textViewPhone = holder.itemView.
                findViewById(R.id.text_user_phone);

        textViewFirstName.setText(user.getFirstName());
        textViewSurName.setText(user.getSurName());
        textViewPhone.setText(user.getPhone());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder
            extends RecyclerView.ViewHolder{

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    User user = users.get(position);
                    listener.onClick(user);

                }
            });

        }
    }

    public interface OnUserClickListener{
        void onClick(User user);
    }
}
