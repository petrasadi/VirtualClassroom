package edu.depaul.se491.josql;

/**
 * {@literal}
 * class PersonException
 *
 * @author Adrian Petras <petrasadi@gmail.com>
 *         Andy Soderstrom <asoderst@gmail.com>
 *         Casey Benzel <casey.benzel@gmail.com>
 *         Elizabeth Stovall <emstovall@gmail.com>
 *         James Raitsev <raitsev@gmail.com>
 */
@SuppressWarnings("serial")
public class PersonException extends Exception
{
    public PersonException(String errorMessage)
    {
        super(errorMessage);
    }

    public PersonException(Throwable throwable)
    {
        super(throwable);
    }
}
