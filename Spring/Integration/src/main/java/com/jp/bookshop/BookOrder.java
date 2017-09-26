/*
 * Copyright (c) Java Pathshala.
 * All rights reserved.
 *
 * This program is protected by copyright law but you are authorise to learn
 * & gain ideas from it. Its unauthorised use is explicitly prohibited &
 * any addition & removal of material. If want to
 * suggest any changes, you are welcome to provide your comments on GitHub
 * Social Code Area. Its unauthorised use gives Java Pathshala the right to
 * obtain retention orders and to prosecute the authors of any infraction.
 * www.javapathshala.com
 */
package com.jp.bookshop;

/**
 *
 * Book order information.
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
class BookOrder
{

    public enum OrderType
    {
        DELIVERY, PICKUP
    }

    private final String title;
    private final int quantity;
    private final OrderType orderType;

    /**
     * Constructor
     */
    public BookOrder(String title, int quantity, OrderType orderType)
    {
        this.title = title;
        this.quantity = quantity;
        this.orderType = orderType;
    }

    /**
     * Gets title.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets quantity.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Gets order type.
     */
    public OrderType getOrderType()
    {
        return orderType;
    }
}
