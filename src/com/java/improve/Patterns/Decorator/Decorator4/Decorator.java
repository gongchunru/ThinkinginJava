package com.java.improve.Patterns.Decorator.Decorator4;

/**
 * Created by gongchunru on 2016/10/24.
 */
public abstract class Decorator extends Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation(){
        component.operation();
    }
}
