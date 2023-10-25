package br.com.hahn.mapper;


import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.apache.commons.collections.list.AbstractLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origem, Class<D> destination){
        return mapper.map(origem, destination);
    }

    public static <O, D> List<D> parseListObject(List<O> origem, Class<D> destination){

        List<D> destinationObjects = new ArrayList<D>();
        for (O o: origem) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;

    }
}
