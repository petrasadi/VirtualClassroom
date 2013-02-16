package edu.depaul.se491.josql;

/**
 * {@literal}
 * class ClassException
 *
 * @author Adrian Petras <petrasadi@gmail.com>
 *         Andy Soderstrom <asoderst@gmail.com>
 *         Casey Benzel <casey.benzel@gmail.com>
 *         Elizabeth Stovall <emstovall@gmail.com>
 *         James Raitsev <raitsev@gmail.com>
 */
@SuppressWarnings("serial")
public class ClassRatingException extends Exception {
    public ClassRatingException(String errorMessage)
    {
        super(errorMessage);
    }

    public ClassRatingException(Throwable throwable)
    {
        super(throwable);
    }
}