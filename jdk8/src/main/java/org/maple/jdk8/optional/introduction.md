## Optional
主要是解决 NPE NullPointerException

if(null !== person){
    Address address = person.getAddress();
    if(null != address ){
        ...
    }
}

