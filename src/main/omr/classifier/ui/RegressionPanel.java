//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                 R e g r e s s i o n P a n e l                                  //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Hervé Bitteur and others 2000-2016. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package omr.classifier.ui;

import omr.classifier.LinearClassifier;
import omr.classifier.ui.TrainingPanel.DumpAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JButton;

/**
 * Class {@code RegressionPanel} is the user interface that handles the training of the
 * linear engine.
 * It is a dedicated companion of class {@link Trainer}.
 *
 * @author Hervé Bitteur
 */
class RegressionPanel
        extends TrainingPanel
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(RegressionPanel.class);

    //~ Constructors -------------------------------------------------------------------------------
    /**
     * Creates a new RegressionPanel object.
     *
     * @param task           the current training activity
     * @param standardWidth  standard width for fields & buttons
     * @param selectionPanel the panel for glyph repository
     */
    public RegressionPanel (Trainer.Task task,
                            String standardWidth,
                            SelectionPanel selectionPanel)
    {
        super(task, standardWidth, LinearClassifier.getInstance(), selectionPanel, 4);
        task.addObserver(this);

        trainAction = new TrainAction("Train");

        defineSpecificLayout();
    }

    @Override
    public void trainingStarted (int epochIndex,
                                 int epochMax,
                                 double mse)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //~ Methods ------------------------------------------------------------------------------------
    //----------------------//
    // defineSpecificLayout //
    //----------------------//
    private void defineSpecificLayout ()
    {
        int r = 7;

        // Training entities
        JButton dumpButton = new JButton(new DumpAction());
        dumpButton.setToolTipText("Dump the classifier internals");

        JButton trainButton = new JButton(trainAction);
        trainButton.setToolTipText("Train the classifier from scratch");

        builder.add(dumpButton, cst.xy(3, r));
        builder.add(trainButton, cst.xy(5, r));
    }
}
