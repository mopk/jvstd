package net.mopk;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.TransformerUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mopk on 2016-08-06.
 */
public class TwoVersionsOfSameLib_test {


    public static void main(String[] args) {

        // The 'ListUtils' class is included in the both 2.1.1 & 3.2.2
        // versions of the apache commons collection library.
        // This class will be loaded successfully, while the both
        // libraries are used on compilation.
        //
        Class klass = ListUtils.class;
        System.out.println(klass);


        // apache commons collections 2.1.1 ListUtils does not contain
        // 'hashCodeForList(..)' method
//        ListUtils.hashCodeForList(new ArrayListIterator());



        // The both 2.1.1 & 3.2.2 versions of library are
        // used simultaneously, see two code fragments below.
        // The fragments are marked with (1.) & (2.).


        // 1. The 'TransformerUtils' class is absent in 2.1.1,
        // but this code can be compiled, even if 2.1.1 dependency is before
        // than 3.2.2 dependency in 'javac ...' run line while compiling.
        Transformer t = TransformerUtils.instantiateTransformer();
        System.out.println(t);


        // 2. MapUtils.getNumber(java.util.Map, java.lang.Object)
        // in 3.2.2 version is without debug output.
        // So here's the test whether we use 2.1.1 or 3.2.2 version:

        Map m = new HashMap<>();

        // the value 'a' cannot be converted to java.lang.Number)
        m.put("key", "a");

        MapUtils.getNumber(m, "key");
    }
}
