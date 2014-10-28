guava-class
===========

Presenting Google Guava

Objects:

    equal()
    toStringHelper()
    hashCode()

Splitter

Joiner

Throwables

Preconditions

    checkArgument()
    checkNotNull()
    checkState()

Ints

    concat(int[]...)
    contains(int[], int)
    indexOf(int[], int)
    lastIndexOf(int[], int)
    max(int...)
    min(int...)
    toArray(Collection<Integer>)

Lists

    newArrayList()
    partition(List<T> list, int size)
    reverse(List)

Maps

    newHashMap()

Sets

    newHashSet(E... elements)
    cartesianProduct(Set...)

Multimap

ImmutableList

    of(E...)
    builder()
    add(E...)
    addAll()
    build()

ImmutableMap

    of(K k1, V v1, K k2, V v2)
    builder()
    put(K, V)
    build()

ImmutableSet

    of(E...)
    builder()
    add(E...)
    build()

Predicate<T>

    boolean apply(T)

Function<F,T>

    T apply(F)

Filter/Transform

    <T> Iterable<T> filter(Iterable<T> unfiltered, Predicate<? super T> predicate)
    <F,T> Iterable<T> transform(Iterable<F> fromIterable, Function<? super F,? extends T> function)

Closures

Hashing

    md5, murmure, sha256

Caching
