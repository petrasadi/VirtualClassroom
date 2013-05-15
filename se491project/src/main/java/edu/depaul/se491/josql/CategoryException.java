package edu.depaul.se491.josql;

/**
 * {@literal}
 * class CategoryException
 *
 * @author Adrian Petras <petrasadi@gmail.com>
 *         Andy Soderstrom <asoderst@gmail.com>
 *         Casey Benzel <casey.benzel@gmail.com>
 *         Elizabeth Stovall <emstovall@gmail.com>
 *         James Raitsev <raitsev@gmail.com>
 */
@SuppressWarnings("serial")
public class CategoryException extends Exception
{
    public CategoryException(String errorMessage)
    {
        super(errorMessage);
    }

    public CategoryException(Throwable throwable)
    {
        super(throwable);
    }
}
