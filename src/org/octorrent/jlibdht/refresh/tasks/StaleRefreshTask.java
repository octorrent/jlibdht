package org.octorrent.jlibdht.refresh.tasks;

import org.octorrent.jlibdht.messages.PingRequest;
import org.octorrent.jlibdht.refresh.tasks.inter.Task;
import org.octorrent.jlibdht.rpc.PingResponseListener;
import org.octorrent.jlibdht.utils.Node;

import java.io.IOException;
import java.util.List;

public class StaleRefreshTask extends Task {

    @Override
    public void execute(){
        PingResponseListener listener = new PingResponseListener(getRoutingTable());
        List<Node> nodes = getRoutingTable().getAllUnqueriedNodes();

        for(Node node : nodes){
            PingRequest request = new PingRequest();
            request.setDestination(node.getAddress());

            try{
                getServer().send(request, node, listener);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
