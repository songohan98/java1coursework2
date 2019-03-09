package uk.ac.ucl.bag;

/**
 * This class implements methods common to all concrete bag implementations
 * but does not represent a complete bag implementation.<br />
 *
 * New bag objects are created using a BagFactory, which can be configured in the application
 * setup to select which bag implementation is to be used.
 */
import java.util.Iterator;

public abstract class AbstractBag<T extends Comparable> implements Bag<T>
{
  public Bag<T> createMergedAllOccurrences(Bag<T> b) throws BagException {
    Bag<T> result = BagFactory.getInstance().getBag();
    for (T value : this)
    {
      result.addWithOccurrences(value, this.countOf(value));
    }
    for (T value : b)
    {
      result.addWithOccurrences(value, b.countOf(value));
    }
    return result;
  }

  public Bag<T> createMergedAllUnique(Bag<T> b) throws BagException {
    Bag<T> result = BagFactory.getInstance().getBag();
    for (T value : this)
    {
      if (!result.contains(value)) result.add(value);
    }
    for (T value : b)
    {
      if (!result.contains(value)) result.add(value);
    }
    return result;
  }

  @Override
  public String toString()
  {
    String returnString = "[ ";
    boolean first = true;
    for(T value : this)
    {
      if (first)
      {
        returnString += value + " : " + this.countOf(value);
        first = false;
      }
      else
        {
          returnString += ", " + value + " : " + this.countOf(value);
        }
    }
    returnString += " ]";
    return returnString;
  }
  public void removeAllCopies()
  {
    for (T value : this)
    {
      while(this.countOf(value)>1)
      {
        remove(value);
      }
    }
  }
  public Bag<T> subtract(Bag<T> bag)
  {
    Bag<T> newbag = bag;
    for(T value : bag)
    {
      if(bag.contains(value))
        newbag.remove(value);
    }
    return newbag;
  }


}
