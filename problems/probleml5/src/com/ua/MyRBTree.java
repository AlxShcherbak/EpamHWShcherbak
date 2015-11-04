package com.ua;

import com.sun.istack.internal.Nullable;

/**
 * Created by AlxEx on 03.11.2015.
 */
public class MyRBTree<K extends Comparable, V> implements MyMap<K, V> {

    Entry<K, V> rootEntry;
    int size;


    public MyRBTree() {
    }

    public <T extends K, E extends V> V put(T key, E value) {
        V returnValue = null;
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (isEmpty()) {
            rootEntry = newEntry;
        } else {
            Entry<K, V> parentEntry = rootEntry;
            boolean insertion = false;
            while (insertion) {
                if (parentEntry.key.compareTo(newEntry.key) > 0) {
                    if (parentEntry.hasLeft()) {
                        parentEntry = parentEntry.left; // вот ошибка, плз хелп!
                    } else {
                        newEntry.parent = parentEntry;
                        size++;
                        insertion = true;
                    }
                } else if (parentEntry.key.compareTo(newEntry.key) < 0) {
                    if (parentEntry.hasRight()) {
                        parentEntry = parentEntry.right;
                    } else {
                        newEntry.parent = parentEntry;
                        size++;
                        insertion = true;
                    }
                } else {
                    returnValue = parentEntry.value;
                    parentEntry.value = value;
                    insertion = true;
                }

            }
        }
        insCase1(newEntry);
        return returnValue;
    }

    /**
     * Текущий узел N в корне дерева. В этом случае, он перекрашивается в чёрный цвет, чтобы оставить верным Свойство 2
     * (Корень — чёрный). Так как это действие добавляет один чёрный узел в каждый путь, Свойство 5 (Все пути от любого
     * данного узла до листовых узлов содержат одинаковое число чёрных узлов) не нарушается.
     *
     * @param entry
     */
    private void insCase1(Entry<K, V> entry) {
        if (entry.parent == null) {
            entry.colorRed = false;
        } else insCase2(entry);
    }

    /**
     * Предок P текущего узла чёрный, то есть Свойство 4 (Оба потомка каждого красного узла — чёрные) не нарушается.
     * В этом случае дерево действительно. Свойство 5 (Все пути от любого данного узла до листовых узлов содержат
     * одинаковое число чёрных узлов) не нарушается, потому что текущий узел N имеет двух чёрных листовых потомков,
     * но так как N является красным, путь до каждого из этих потомков содержит такое же число чёрных узлов, что и путь
     * до чёрного листа, который был заменен текущим узлом, так что свойство остается верным.
     *
     * @param entry
     */
    private void insCase2(Entry<K, V> entry) {
        if (!entry.parent.colorRed) {
            return;
        } else insCase3(entry);
    }

    /**
     * Если и родитель P и дядя U — красные, то они оба могут быть перекрашены в чёрный и дедушка G станет красным
     * (для сохранения свойства 5 (Все пути от любого данного узла до листовых узлов содержат одинаковое число чёрных
     * узлов)). Теперь у текущего красного узла N чёрный родитель. Так как любой путь через родителя или дядю должен
     * проходить через дедушку, число чёрных узлов в этих путях не изменится. Однако, дедушка G теперь может нарушить
     * свойства 2 (Корень — чёрный) или 4 (Оба потомка каждого красного узла — чёрные) (свойство 4 может быть
     * нарушено, так как родитель G может быть красным). Чтобы это исправить, вся процедура рекурсивно выполняется
     * на G из случая 1.
     *
     * @param entry
     */
    private void insCase3(Entry<K, V> entry) {
        Entry<K, V> uncle = uncle(entry);
        if (uncle != null && uncle.colorRed && entry.parent.colorRed) {
            entry.parent.colorRed = false;
            uncle.colorRed = false;

            Entry<K, V> grdParent = grdParent(entry);
            grdParent.colorRed = true;
            insCase1(grdParent);
        } else insCase4(entry);
    }

    /**
     * Родитель P является красным, но дядя U — чёрный. Также, текущий узел N — правый потомок P, а P в свою очередь —
     * левый потомок своего предка G. В этом случае может быть произведен поворот дерева, который меняет роли текущего
     * узла N и его предка P. Тогда, для бывшего родительского узла P в обновленно структуре используем случай 5, потому
     * что Свойство 4 (Оба потомка любого красного узла — чёрные) все ещё нарушено. Вращение приводит к тому, что
     * некоторые пути (в поддереве, обозначенном «1» на схеме) проходят через узел N, чего не было до этого. Это также
     * приводит к тому, что некоторые пути (в поддереве, обозначенном «3») не проходят через узел P. Однако, оба эти
     * узла являются красными, так что Свойство 5 (Все пути от любого данного узла до листовых узлов содержат одинаковое
     * число чёрных узлов) не нарушается при вращении. Однако Свойство 4 всё ещё нарушается, задача сводится к Случаю 5.
     *
     * @param entry
     */
    private void insCase4(Entry<K, V> entry) {
        Entry<K, V> grdParent = grdParent(entry);
        if (entry == entry.parent.right && entry.parent == grdParent.left) {
            rotateLeft(entry);
            entry = entry.left;
        } else if (entry == entry.parent.left && entry.parent == grdParent.right) {
            rotateRight(entry);
            entry = entry.right;
        }
        insCase5(entry);
    }

    /**
     * Родитель P является красным, но дядя U — чёрный, текущий узел N — левый потомок P и P — левый потомок G.
     * В этом случае выполняется поворот дерева на G. В результате получается дерево, в котором бывший родитель P
     * теперь является родителем и текущего узла N и бывшего дедушки G. Известно, что G — чёрный, так как его бывший
     * потомок P не мог бы в противном случае быть красным (без нарушения Свойства 4). Тогда цвета P и G меняются и в
     * результате дерево удовлетворяет Свойству 4 (Оба потомка любого красного узла — чёрные). Свойство 5 (Все пути от
     * любого данного узла до листовых узлов содержат одинаковое число чёрных узлов) также остается верным, так как все
     * пути, которые проходят через любой из этих трех узлов, ранее проходили через G, поэтому теперь они все проходят
     * через P. В каждом случае, из этих трех узлов только один окрашен в чёрный
     *
     * @param entry
     */
    private void insCase5(Entry<K, V> entry) {
        /*
         * Code C++
         *
         * struct node *g = grandparent(n);
         *
         * n->parent->color = BLACK;
         * g->color = RED;
         * if ((n == n->parent->left) && (n->parent == g->left)) {
         * rotate_right(g);
         * } else { *//* (n == n->parent->right) && (n->parent == g->right) *//*
         * rotate_left(g);
         */
    }

    private void rotateLeft(Entry<K, V> entry) {
        /*
         * code C++
         *
		 * rotate_left может быть выполнен следующим образом, учитывая что уже есть *g =  grandparent(n)
		 *
		 * struct node *saved_p=g->left, *saved_left_n=n->left;
		 * g->left=n;
		 * n->left=saved_p;
		 * saved_p->right=saved_left_n;
		 *
		 */
    }

    private void rotateRight(Entry<K, V> entry) {
        /*
         * Code C++
         *
		 * rotate_right может быть выполнен следующим образом, учитывая что уже есть *g =  grandparent(n)
		 *
		 * struct node *saved_p=g->right, *saved_right_n=n->right;
		 * g->right=n;
		 * n->right=saved_p;
		 * saved_p->left=saved_right_n;
		 *
		 */
    }

    public V get(K key) {
        return null;
    }

    public V remove(K key) {
        return null;
    }

    /**
     * N — новый корень. В этом случае, все сделано. Мы удалили один чёрный узел из каждого пути и новый корень
     * является чёрным узлом, так что свойства сохранены.
     *
     * @param entry
     */
    private void deleteCase1(Entry<K, V> entry) {

    }

    /**
     * S — красный. В этом случае мы меняем цвета P и S, и затем делаем вращение влево вокруг P, ставя S дедушкой N.
     * Нужно заметить, что P должен быть чёрным, если он имеет красного потомка. Хотя все пути по прежнему содержат
     * одинаковое количество чёрных узлов, сейчас N имеет чёрного брата и красного отца. Таким образом, мы можем
     * перейти к шагу 4, 5 или 6. (Его новый брат является чёрным потому, что он был потомком красного S.) Далее
     * через S будет обозначен новый брат N.
     *
     * @param entry
     */
    private void deleteCas2(Entry<K, V> entry) {

    }

    /**
     * P, S, и дети S' — чёрные. В этом случае мы просто перекрашиваем S в красный. В результате все пути, проходящие
     * через S, но не проходящие через N, имеют на один чёрный узел меньше. Так как удаления отца N приводит к тому,
     * что все пути, проходящие через N, содержат на один чёрный узел меньше, то такие действия выравнивают баланс.
     * Тем не менее, все проходящие через P пути теперь содержать на один чёрный узел меньше, чем пути, которые
     * через P не проходят, поэтому свойство 5 (все пути из любой вершины к её листовым узлам содержат одинаковое
     * количество чёрных узлов) все ещё нарушено. Чтобы это исправить, мы применяем процедуру перебалансировки к P,
     * начиная со случая 1.
     *
     * @param entry
     */
    private void deleteCase3(Entry<K, V> entry) {

    }

    /**
     * S и его дети — чёрные, но P — красный. В этом случае мы просто меняем цвета S и P. Это не влияет на количество
     * чёрных узлов на путях, проходящих через S, но добавит один к числу чёрных узлов на путях, проходящих через N,
     * восстанавливая тем самым влиянние удаленного чёрного узла.
     *
     * @param entry
     */
    private void deleteCase4(Entry<K, V> entry) {

    }

    /**
     * S — чёрный, левый потомок S — красный, правый потомок S — чёрный, и N является левым потомков своего отца.
     * В этом случае мы вращаем дерево вправо вокруг S. Таким образом левый потомок S становится его отцом и новым
     * братом N. После этого мы меняем цвета у S и его нового отца. Все пути по прежнему содержат одинаковое количество
     * чёрных узлов, но теперь у N есть чёрный брат с красным правым потомком, и мы переходим к случаю 6. Ни N, ни его
     * отец не влияют на эту трансформацию. (Для случая 6 мы обозначим через S нового брата N.)
     *
     * @param entry
     */
    private void deleteCase5(Entry<K, V> entry) {

    }

    /**
     * S — чёрный, правый потомок S — красный, и N является левым потомком своего отца P. В этом случае мы вращаем
     * дерево влево вокруг P, после чего S становится отцом P и своего правого потомка. Далее мы изменяем цвета у P и S,
     * и делаем правого потомка S чёрным.
     *
     * @param entry
     */
    private void deleteCase6(Entry<K, V> entry) {

    }

    public boolean consistKey(K key) {
        return false;
    }

    public boolean consistValue(V value) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    @Nullable
    private Entry<K, V> grdParent(Entry<K, V> entry) {
        if (entry.parent != null && entry.parent.parent != null) {
            return entry.parent.parent;
        }
        return null;
    }

    @Nullable
    private Entry<K, V> uncle(Entry<K, V> entry) {
        Entry grdParent = grdParent(entry);
        if (grdParent != null) {
            if (entry.parent == grdParent.left) {
                return grdParent.right;
            } else return grdParent.left;
        }
        return null;
    }


    private class Entry<K extends Comparable, V> {
        Entry<K, V> parent;
        Entry<K, V> left;
        Entry<K, V> right;

        K key;
        V value;
        boolean colorRed;   // true - RED, false - black

        Entry() {
        }

        <T extends K, E extends V> Entry(T key, E value) {
            parent = null;
            left = null;
            right = null;

            this.key = key;
            this.value = value;
            this.colorRed = true;
        }

        <T extends K, E extends V> Entry(Entry parent, T key, E value) {
            this.parent = parent;
            this.left = null;
            this.right = null;

            this.key = key;
            this.value = value;
            this.colorRed = true;
        }

        boolean hasLeft() {
            return left != null;
        }

        boolean hasRight() {
            return right != null;
        }

        void remove() {
            if (hasLeft()) {
                if (this == parent.right) {
                    parent.right = this.left;
                }
            }
        }
    }

    private class NIL extends Entry {
        final boolean colorRed = false;
        final Entry left = null;
        final Entry right = null;
        final V value = null;
    }
}
