package org.sectorrent.jlibdht.rpc.events.inter;

import org.sectorrent.jlibdht.utils.ReflectMethod;

import java.util.Comparator;

public class PriorityComparator implements Comparator<ReflectMethod> {

    @Override
    public int compare(ReflectMethod a, ReflectMethod b){
        int a1 = a.getMethod().getAnnotation(RequestMapping.class).priority().getValue();
        int b1 = b.getMethod().getAnnotation(RequestMapping.class).priority().getValue();
        return (a1 == b1) ? 0 : (a1 > b1) ? -1 : 1;
    }
}
