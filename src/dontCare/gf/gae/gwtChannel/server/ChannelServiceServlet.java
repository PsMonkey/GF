/**
 * Copyright (c) 2012, Eirik Brandtzæg
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  *  Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  *  Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL EIRIK BRANDTZÆG BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package dontCare.gf.gae.gwtChannel.server;

import java.lang.reflect.Method;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.user.server.rpc.SerializationPolicy;

import dontCare.gf.gae.gwtChannel.client.ChannelService;
import dontCare.gf.gae.gwtChannel.client.GetMessageService;
import dontCare.gf.gae.gwtChannel.client.Message;

@SuppressWarnings("serial")
public abstract class ChannelServiceServlet<M extends Message> extends RemoteServiceServlet implements ChannelService<M>{
	
	//Refactory 改成 static method 就好了？
	@Override
	public final void sendMessage(String name, M message) {
		try {
			Method serviceMethod = GetMessageService.class.getMethod("getMessage", Message.class);

			// Yes, the SerializationPolicy is a hack
			String serialized = RPC.encodeResponseForSuccess(serviceMethod, message, new SerializationPolicy() {
					@Override
					public void validateSerialize(Class<?> clazz)
							throws SerializationException {
					}

					@Override
					public void validateDeserialize(Class<?> clazz) throws SerializationException {}

					@Override
					public boolean shouldSerializeFields(Class<?> clazz) {
						return false;
					}

					@Override
					public boolean shouldDeserializeFields(Class<?> clazz) {
						return false;
					}
			});
			ChannelServiceFactory.getChannelService().sendMessage(new ChannelMessage(name, serialized));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SerializationException e) {
			e.printStackTrace();
		}
	}
}