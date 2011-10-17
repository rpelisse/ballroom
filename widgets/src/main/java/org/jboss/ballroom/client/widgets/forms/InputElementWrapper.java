/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */

package org.jboss.ballroom.client.widgets.forms;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.ballroom.client.widgets.icons.Icons;

/**
 * @author Heiko Braun
 * @date 3/28/11
 */
class InputElementWrapper extends HorizontalPanel {

    private Image err = new Image(Icons.INSTANCE.exclamation());
    private Image expr = new Image(Icons.INSTANCE.expression());

    public InputElementWrapper(Widget widget, final InputElement input) {
        super();
        add(widget);

        add(expr);
        expr.setVisible(false);
        expr.getElement().getParentElement().setAttribute("style", "width:16px;vertical-align:middle");

        /*

        TODO: resolve expressions

        expr.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                PopupPanel popup = new PopupPanel(true);
                popup.getElement().setAttribute("style", "z-index:20");
                popup.setWidget(new Label(input.getErrMessage()));
                popup.setStyleName("popup-hint");
                popup.setPopupPosition(err.getAbsoluteLeft()+16, err.getAbsoluteTop()+16);
                popup.show();
            }
        });*/

        // error icon
        add(err);
        err.setVisible(false);
        err.getElement().getParentElement().setAttribute("style", "width:16px;vertical-align:middle");

        err.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                PopupPanel popup = new PopupPanel(true);
                popup.getElement().setAttribute("style", "z-index:20");
                popup.setWidget(new Label(input.getErrMessage()));
                popup.setStyleName("popup-hint");
                popup.setPopupPosition(err.getAbsoluteLeft()+16, err.getAbsoluteTop()+16);
                popup.show();
            }
        });
    }

    public void setErroneous(boolean hasErrors)
    {
        err.setVisible(hasErrors);
    }

    public void setExpression(boolean isExpression)
    {
        expr.setVisible(isExpression);
    }

}
