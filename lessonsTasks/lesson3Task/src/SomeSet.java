/**
 * Created by AlxEx on 22.10.2015.
 */
public class SomeSet {
    Container container;

    public SomeSet(Container container) {
        this.container = container;
    }

    public Container getContainer() {
        return container;
    }

    public SomeSet union(SomeSet otherSet){
        SomeSet resultSet = new SomeSet(this.container.clone());

        for (int i = 0; i < otherSet.getContainer().size(); i++) {
            Object element = otherSet.getContainer().get(i);
            if (!otherSet.getContainer().contains(element)) {
                //otherSet.getContainer().add(element);
            }
        }

        return resultSet;
    }
}
