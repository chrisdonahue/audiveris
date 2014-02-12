//----------------------------------------------------------------------------//
//                                                                            //
//                              P o i n t U t i l                             //
//                                                                            //
//----------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2013. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//----------------------------------------------------------------------------//
// </editor-fold>
package omr.math;

import java.awt.geom.Point2D;

/**
 * Class {@code PointUtil} gathers utility methods for points
 * (and vectors).
 *
 * @author Hervé Bitteur
 */
public class PointUtil
{
    //~ Methods ----------------------------------------------------------------

    //----------//
    // addition //
    //----------//
    /**
     * Report the vector which is the addition of the 2 vectors.
     *
     * @param p1 a vector
     * @param p2 another vector
     * @return the geometric addition
     */
    public static Point2D addition (Point2D p1,
                                    Point2D p2)
    {
        return new Point2D.Double(p1.getX() + p2.getX(), p1.getY() + p2.getY());
    }

    //------------//
    // dotProduct //
    //------------//
    /**
     * Report the dot product between two vectors.
     *
     * @param p1 a vector
     * @param p2 another vector
     * @return |p1|.|p2|.cos(theta)
     */
    public static double dotProduct (Point2D p1,
                                     Point2D p2)
    {
        return (p1.getX() * p2.getX()) + (p1.getY() * p2.getY());
    }

    //-----------//
    // extension //
    //-----------//
    /**
     * Compute extension point, on line p1 -> p2, at 'dist' distance
     * beyond p2.
     *
     * @param p1   first point
     * @param p2   second point
     * @param dist distance beyond p2
     * @return the extension point
     */
    public static Point2D extension (Point2D p1,
                                     Point2D p2,
                                     double dist)
    {
        double seg = p1.distance(p2);

        return new Point2D.Double(
                p2.getX() + ((dist * (p2.getX() - p1.getX())) / seg),
                p2.getY() + ((dist * (p2.getY() - p1.getY())) / seg));
    }

    //--------//
    // length //
    //--------//
    /**
     * Report the length of a vector
     *
     * @param p a vector
     * @return the vector module
     */
    public static double length (Point2D p)
    {
        return Math.hypot(p.getX(), p.getY());
    }

    //-------------//
    // subtraction //
    //-------------//
    /**
     * Report the vector which represent p2 - p1.
     *
     * @param p1 a vector
     * @param p2 another vector
     * @return the geometric subtraction
     */
    public static Point2D subtraction (Point2D p1,
                                       Point2D p2)
    {
        return new Point2D.Double(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }
}
