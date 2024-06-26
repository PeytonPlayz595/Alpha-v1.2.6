package net.lax1dude.eaglercraft.adapter;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.ARBDebugOutput;
import org.lwjgl.opengl.ARBDebugOutputCallback;
import org.lwjgl.opengl.ARBOcclusionQuery2;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.EXTTextureFilterAnisotropic;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

import de.cuina.fireandfuel.CodecJLayerMP3;
import net.lax1dude.eaglercraft.AssetRepository;
import net.lax1dude.eaglercraft.EaglerImage;
import net.lax1dude.eaglercraft.GameWindowListener;
import net.lax1dude.eaglercraft.adapter.sound.LibraryLWJGLOpenAL;
import net.minecraft.src.MathHelper;

import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;

public class EaglerAdapterImpl2 {

	public static final boolean _wisWebGL() {
		return false;
	}

	public static final boolean _wisAnisotropicPatched() {
		return true;
	}

	public static final String _wgetShaderHeader() {
		return "#version 150";
	}

	public static final InputStream loadResource(String path) {
		byte[] file = loadResourceBytes(path);
		if (file != null) {
			return new ByteArrayInputStream(file);
		} else {
			return null;
		}
	}

	public static final boolean isSSLPage() {
		return true;
	}

	public static final String[] getIdentifier() {
		return new String[0];
	}

	private static final boolean useEPKTest = false;

	public static final byte[] loadResourceBytes(String path) {
		if (useEPKTest) {
			return AssetRepository.getResource(path);
		} else {
			try {
				InputStream stream;
				try {
					stream = new FileInputStream(new File("resources", path));
				} catch (FileNotFoundException e) {
					return null;
				}
				byte[] targetArray = new byte[stream.available()];
				stream.read(targetArray);
				stream.close();
				return targetArray;
			} catch (IOException e) {
				return null;
			}
		}
	}

	public static final String fileContents(String path) {
		byte[] contents = loadResourceBytes(path);
		if (contents == null) {
			return null;
		} else {
			return new String(contents, Charset.forName("UTF-8"));
		}
	}

	public static final String[] fileContentsLines(String path) {
		String contents = fileContents(path);
		if (contents == null) {
			return null;
		} else {
			return contents.replace("\r\n", "\n").split("[\r\n]");
		}
	}

	public static final void setDebugVar(String v, String s) {

	}

	public static final int _wGL_TEXTURE_2D = GL11.GL_TEXTURE_2D;
	public static final int _wGL_DEPTH_TEST = GL11.GL_DEPTH_TEST;
	public static final int _wGL_LEQUAL = GL11.GL_LEQUAL;
	public static final int _wGL_GEQUAL = GL11.GL_GEQUAL;
	public static final int _wGL_GREATER = GL11.GL_GREATER;
	public static final int _wGL_LESS = GL11.GL_LESS;
	public static final int _wGL_BACK = GL11.GL_BACK;
	public static final int _wGL_FRONT = GL11.GL_FRONT;
	public static final int _wGL_FRONT_AND_BACK = GL11.GL_FRONT_AND_BACK;
	public static final int _wGL_COLOR_BUFFER_BIT = GL11.GL_COLOR_BUFFER_BIT;
	public static final int _wGL_DEPTH_BUFFER_BIT = GL11.GL_DEPTH_BUFFER_BIT;
	public static final int _wGL_BLEND = GL11.GL_BLEND;
	public static final int _wGL_RGBA = GL11.GL_RGBA;
	public static final int _wGL_RGB = GL11.GL_RGB;
	public static final int _wGL_RGB8 = GL11.GL_RGB8;
	public static final int _wGL_RGBA8 = GL11.GL_RGBA8;
	public static final int _wGL_UNSIGNED_BYTE = GL11.GL_UNSIGNED_BYTE;
	public static final int _wGL_UNSIGNED_SHORT = GL11.GL_UNSIGNED_SHORT;
	public static final int _wGL_TEXTURE_WIDTH = GL11.GL_TEXTURE_WIDTH;
	public static final int _wGL_SRC_ALPHA = GL11.GL_SRC_ALPHA;
	public static final int _wGL_ONE_MINUS_SRC_ALPHA = GL11.GL_ONE_MINUS_SRC_ALPHA;
	public static final int _wGL_ONE_MINUS_DST_COLOR = GL11.GL_ONE_MINUS_DST_COLOR;
	public static final int _wGL_ONE_MINUS_SRC_COLOR = GL11.GL_ONE_MINUS_SRC_COLOR;
	public static final int _wGL_ZERO = GL11.GL_ZERO;
	public static final int _wGL_CULL_FACE = GL11.GL_CULL_FACE;
	public static final int _wGL_TEXTURE_MIN_FILTER = GL11.GL_TEXTURE_MIN_FILTER;
	public static final int _wGL_TEXTURE_MAG_FILTER = GL11.GL_TEXTURE_MAG_FILTER;
	public static final int _wGL_LINEAR = GL11.GL_LINEAR;
	public static final int _wGL_NEAREST_MIPMAP_LINEAR = GL11.GL_NEAREST_MIPMAP_LINEAR;
	public static final int _wGL_LINEAR_MIPMAP_LINEAR = GL11.GL_LINEAR_MIPMAP_LINEAR;
	public static final int _wGL_LINEAR_MIPMAP_NEAREST = GL11.GL_LINEAR_MIPMAP_NEAREST;
	public static final int _wGL_NEAREST_MIPMAP_NEAREST = GL11.GL_NEAREST_MIPMAP_NEAREST;
	public static final int _wGL_EQUAL = GL11.GL_EQUAL;
	public static final int _wGL_SRC_COLOR = GL11.GL_SRC_COLOR;
	public static final int _wGL_ONE = GL11.GL_ONE;
	public static final int _wGL_NEAREST = GL11.GL_NEAREST;
	public static final int _wGL_CLAMP = GL12.GL_CLAMP_TO_EDGE;
	public static final int _wGL_TEXTURE_WRAP_S = GL11.GL_TEXTURE_WRAP_S;
	public static final int _wGL_TEXTURE_WRAP_T = GL11.GL_TEXTURE_WRAP_T;
	public static final int _wGL_TEXTURE_MAX_LEVEL = GL12.GL_TEXTURE_MAX_LEVEL;
	public static final int _wGL_REPEAT = GL11.GL_REPEAT;
	public static final int _wGL_DST_COLOR = GL11.GL_DST_COLOR;
	public static final int _wGL_DST_ALPHA = GL11.GL_DST_ALPHA;
	public static final int _wGL_FLOAT = GL11.GL_FLOAT;
	public static final int _wGL_SHORT = GL11.GL_SHORT;
	public static final int _wGL_TRIANGLES = GL11.GL_TRIANGLES;
	public static final int _wGL_TRIANGLE_STRIP = GL11.GL_TRIANGLE_STRIP;
	public static final int _wGL_TRIANGLE_FAN = GL11.GL_TRIANGLE_FAN;
	public static final int _wGL_LINE_STRIP = GL11.GL_LINE_STRIP;
	public static final int _wGL_LINES = GL11.GL_LINES;
	public static final int _wGL_PACK_ALIGNMENT = GL11.GL_PACK_ALIGNMENT;
	public static final int _wGL_UNPACK_ALIGNMENT = GL11.GL_UNPACK_ALIGNMENT;
	public static final int _wGL_TEXTURE0 = GL13.GL_TEXTURE0;
	public static final int _wGL_TEXTURE1 = GL13.GL_TEXTURE1;
	public static final int _wGL_TEXTURE2 = GL13.GL_TEXTURE2;
	public static final int _wGL_TEXTURE3 = GL13.GL_TEXTURE3;
	public static final int _wGL_VIEWPORT = GL11.GL_VIEWPORT;
	public static final int _wGL_VERTEX_SHADER = GL20.GL_VERTEX_SHADER;
	public static final int _wGL_FRAGMENT_SHADER = GL20.GL_FRAGMENT_SHADER;
	public static final int _wGL_ARRAY_BUFFER = GL15.GL_ARRAY_BUFFER;
	public static final int _wGL_ELEMENT_ARRAY_BUFFER = GL15.GL_ELEMENT_ARRAY_BUFFER;
	public static final int _wGL_STATIC_DRAW = GL15.GL_STATIC_DRAW;
	public static final int _wGL_DYNAMIC_DRAW = GL15.GL_DYNAMIC_DRAW;
	public static final int _wGL_STREAM_DRAW = GL15.GL_STREAM_DRAW;
	public static final int _wGL_INVALID_ENUM = GL11.GL_INVALID_ENUM;
	public static final int _wGL_INVALID_VALUE = GL11.GL_INVALID_VALUE;
	public static final int _wGL_INVALID_OPERATION = GL11.GL_INVALID_OPERATION;
	public static final int _wGL_OUT_OF_MEMORY = GL11.GL_OUT_OF_MEMORY;
	public static final int _wGL_CONTEXT_LOST_WEBGL = -1;
	public static final int _wGL_FRAMEBUFFER_COMPLETE = GL30.GL_FRAMEBUFFER_COMPLETE;
	public static final int _wGL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = GL30.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT;
	public static final int _wGL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = GL30.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT;
	public static final int _wGL_COLOR_ATTACHMENT0 = GL30.GL_COLOR_ATTACHMENT0;
	public static final int _wGL_DEPTH_STENCIL_ATTACHMENT = GL30.GL_DEPTH_STENCIL_ATTACHMENT;
	public static final int _wGL_DEPTH_ATTACHMENT = GL30.GL_DEPTH_ATTACHMENT;
	public static final int _wGL_DEPTH_COMPONENT32F = GL30.GL_DEPTH_COMPONENT32F;
	public static final int _wGL_DEPTH_STENCIL = GL30.GL_DEPTH_STENCIL;
	public static final int _wGL_DEPTH24_STENCIL8 = GL30.GL_DEPTH24_STENCIL8;
	public static final int _wGL_UNSIGNED_INT_24_8 = GL30.GL_UNSIGNED_INT_24_8;
	public static final int _wGL_UNSIGNED_INT = GL11.GL_UNSIGNED_INT;
	public static int _wGL_ANY_SAMPLES_PASSED = -1;
	public static final int _wGL_QUERY_RESULT = GL15.GL_QUERY_RESULT;
	public static final int _wGL_QUERY_RESULT_AVAILABLE = GL15.GL_QUERY_RESULT_AVAILABLE;
	public static int _wGL_TEXTURE_MAX_ANISOTROPY = -1;
	public static final int _wGL_R8 = GL30.GL_R8;
	public static final int _wGL_R32UI = GL30.GL_R32UI;
	public static final int _wGL_RED = GL11.GL_RED;
	public static final int _wGL_RENDERBUFFER = GL30.GL_RENDERBUFFER;
	public static final int _wGL_MULTISAMPLE = GL13.GL_MULTISAMPLE;
	public static final int _wGL_LINE_SMOOTH = GL11.GL_LINE_SMOOTH;
	public static final int _wGL_DRAW_FRAMEBUFFER = GL30.GL_DRAW_FRAMEBUFFER;
	public static final int _wGL_READ_FRAMEBUFFER = GL30.GL_READ_FRAMEBUFFER;
	public static final int _wGL_FRAMEBUFFER = GL30.GL_FRAMEBUFFER;
	public static final int _wGL_POLYGON_OFFSET_FILL = GL11.GL_POLYGON_OFFSET_FILL;

	public static final class TextureGL {
		protected final int obj;
		
		protected TextureGL(int obj) {
			this.obj = obj;
		}
	}

	public static final class BufferGL {
		protected final int obj;

		protected BufferGL(int obj) {
			this.obj = obj;
		}
	}

	public static final class ShaderGL {
		protected final int obj;

		protected ShaderGL(int obj) {
			this.obj = obj;
		}
	}

	public static final class ProgramGL {
		protected final int obj;

		protected ProgramGL(int obj) {
			this.obj = obj;
		}
	}

	public static final class UniformGL {
		protected final int obj;

		protected UniformGL(int obj) {
			this.obj = obj;
		}
	}

	public static final class BufferArrayGL {
		protected final int obj;
		public boolean isQuadBufferBound;

		protected BufferArrayGL(int obj) {
			this.obj = obj;
			this.isQuadBufferBound = false;
		}
	}

	public static final class FramebufferGL {
		protected final int obj;

		protected FramebufferGL(int obj) {
			this.obj = obj;
		}
	}

	public static final class RenderbufferGL {
		protected final int obj;

		protected RenderbufferGL(int obj) {
			this.obj = obj;
		}
	}

	public static final class QueryGL {
		protected final int obj;

		protected QueryGL(int obj) {
			this.obj = obj;
		}
	}

	public static final void _wglEnable(int p1) {
		GL11.glEnable(p1);
	}

	public static final void _wglClearDepth(float p1) {
		GL11.glClearDepth(p1);
	}

	public static final void _wglDepthFunc(int p1) {
		GL11.glDepthFunc(p1);
	}

	public static final void _wglCullFace(int p1) {
		GL11.glCullFace(p1);
	}

	private static final int[] viewport = new int[4];

	public static final void _wglViewport(int p1, int p2, int p3, int p4) {
		viewport[0] = p1;
		viewport[1] = p2;
		viewport[2] = p3;
		viewport[3] = p4;
		GL11.glViewport(p1, p2, p3, p4);
	}

	public static final void _wglClear(int p1) {
		GL11.glClear(p1);
	}

	public static final void _wglClearColor(float p1, float p2, float p3, float p4) {
		GL11.glClearColor(p1, p2, p3, p4);
	}

	public static final void _wglDisable(int p1) {
		GL11.glDisable(p1);
	}

	public static final int _wglGetError() {
		return GL11.glGetError();
	}

	public static final void _wglFlush() {
		GL11.glFlush();
	}

	public static final void _wglTexImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
			ByteBuffer p9) {
		GL11.glTexImage2D(p1, p2, p3, p4, p5, p6, p7, p8, p9);
	}

	public static final void _wglBlendFunc(int p1, int p2) {
		GL11.glBlendFunc(p1, p2);
	}

	public static final void _wglDepthMask(boolean p1) {
		GL11.glDepthMask(p1);
	}

	public static final void _wglColorMask(boolean p1, boolean p2, boolean p3, boolean p4) {
		GL11.glColorMask(p1, p2, p3, p4);
	}

	public static final void _wglBindTexture(int p1, TextureGL p2) {
		GL11.glBindTexture(p1, p2 == null ? 0 : p2.obj);
	}

	public static final void _wglCopyTexSubImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
		GL11.glCopyTexSubImage2D(p1, p2, p3, p4, p5, p6, p7, p8);
	}

	public static final void _wglTexParameteri(int p1, int p2, int p3) {
		GL11.glTexParameteri(p1, p2, p3);
	}

	public static final void _wglTexParameterf(int p1, int p2, int p3) {
		GL11.glTexParameterf(p1, p2, p3);
	}

	public static final void _wglTexImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
			IntBuffer p9) {
		GL11.glTexImage2D(p1, p2, p3, p4, p5, p6, p7, p8, p9);
	}

	public static final void _wglTexSubImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
			IntBuffer p9) {
		GL11.glTexSubImage2D(p1, p2, p3, p4, p5, p6, p7, p8, p9);
	}

	public static final void _wglDeleteTextures(TextureGL p1) {
		GL11.glDeleteTextures(p1.obj);
	}

	public static final void _wglDrawArrays(int p1, int p2, int p3) {
		GL11.glDrawArrays(p1, p2, p3);
	}

	public static final void _wglDrawElements(int p1, int p2, int p3, int p4) {
		GL11.glDrawElements(p1, p2, p3, p4);
	}

	public static final TextureGL _wglGenTextures() {
		return new TextureGL(GL11.glGenTextures());
	}

	public static final void _wglTexSubImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
			ByteBuffer p9) {
		GL11.glTexSubImage2D(p1, p2, p3, p4, p5, p6, p7, p8, p9);
	}

	public static final void _wglTexImage3D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9,
			ByteBuffer p10) {
		GL12.glTexImage3D(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
	}

	public static final void _wglTexParameterf(int p1, int p2, float p3) {
		GL11.glTexParameterf(p1, p2, p3);
	}

	public static final void _wglActiveTexture(int p1) {
		GL13.glActiveTexture(p1);
	}

	public static final String _wgluErrorString(int p1) {
		return GLU.gluErrorString(p1);
	}

	public static final ProgramGL _wglCreateProgram() {
		return new ProgramGL(GL20.glCreateProgram());
	}

	public static final ShaderGL _wglCreateShader(int p1) {
		return new ShaderGL(GL20.glCreateShader(p1));
	}

	public static final void _wglAttachShader(ProgramGL p1, ShaderGL p2) {
		GL20.glAttachShader(p1.obj, p2.obj);
	}

	public static final void _wglDetachShader(ProgramGL p1, ShaderGL p2) {
		GL20.glDetachShader(p1.obj, p2.obj);
	}

	public static final void _wglCompileShader(ShaderGL p1) {
		GL20.glCompileShader(p1.obj);
	}

	public static final void _wglLinkProgram(ProgramGL p1) {
		GL20.glLinkProgram(p1.obj);
	}

	public static final void _wglShaderSource(ShaderGL p1, String p2) {
		GL20.glShaderSource(p1.obj, p2);
	}

	public static final String _wglGetShaderInfoLog(ShaderGL p1) {
		return GL20.glGetShaderInfoLog(p1.obj, 8192);
	}

	public static final String _wglGetProgramInfoLog(ProgramGL p1) {
		return GL20.glGetProgramInfoLog(p1.obj, 8192);
	}

	public static final boolean _wglGetShaderCompiled(ShaderGL p1) {
		return GL20.glGetShaderi(p1.obj, GL20.GL_COMPILE_STATUS) == GL11.GL_TRUE;
	}

	public static final boolean _wglGetProgramLinked(ProgramGL p1) {
		return GL20.glGetProgrami(p1.obj, GL20.GL_LINK_STATUS) == GL11.GL_TRUE;
	}

	public static final void _wglDeleteShader(ShaderGL p1) {
		GL20.glDeleteShader(p1.obj);
	}

	public static final void _wglDeleteProgram(ProgramGL p1) {
		GL20.glDeleteProgram(p1.obj);
	}

	public static final BufferArrayGL _wglCreateVertexArray() {
		return new BufferArrayGL(GL30.glGenVertexArrays());
	}

	public static final void _wglDeleteVertexArray(BufferArrayGL p1) {
		GL30.glDeleteVertexArrays(p1.obj);
	}

	public static final void _wglBindVertexArray(BufferArrayGL p1) {
		GL30.glBindVertexArray(p1 == null ? 0 : p1.obj);
	}

	public static final BufferGL _wglCreateBuffer() {
		return new BufferGL(GL15.glGenBuffers());
	}

	public static final void _wglDeleteBuffer(BufferGL p1) {
		GL15.glDeleteBuffers(p1.obj);
	}

	public static final void _wglBindBuffer(int p1, BufferGL p2) {
		GL15.glBindBuffer(p1, p2 == null ? 0 : p2.obj);
	}

	public static final void _wglBufferData(int p1, Object p2, int p3) {
		GL15.glBufferData(p1, (IntBuffer) p2, p3);
	}

	public static final void _wglBufferSubData(int p1, int p2, Object p3) {
		GL15.glBufferSubData(p1, p2, (IntBuffer) p3);
	}

	public static final void _wglBufferData0(int p1, IntBuffer p2, int p3) {
		GL15.glBufferData(p1, p2, p3);
	}
	
	public static final void _wglBufferData00(int p1, long len, int p3) {
		GL15.glBufferData(p1, len, p3);
	}

	public static final void _wglBufferSubData0(int p1, int p2, IntBuffer p3) {
		GL15.glBufferSubData(p1, p2, p3);
	}

	public static final void _wglBindAttribLocation(int p1, int p2, String p3) {
		GL20.glBindAttribLocation(p1, p2, p3);
	}

	public static final void _wglEnableVertexAttribArray(int p1) {
		GL20.glEnableVertexAttribArray(p1);
	}

	public static final void _wglDisableVertexAttribArray(int p1) {
		GL20.glDisableVertexAttribArray(p1);
	}

	public static final UniformGL _wglGetUniformLocation(ProgramGL p1, String p2) {
		int u = GL20.glGetUniformLocation(p1.obj, p2);
		return u == -1 ? null : new UniformGL(u);
	}

	public static final void _wglBindAttributeLocation(ProgramGL p1, int p2, String p3) {
		GL20.glBindAttribLocation(p1.obj, p2, p3);
	}

	public static final void _wglUniform1f(UniformGL p1, float p2) {
		if (p1 != null)
			GL20.glUniform1f(p1.obj, p2);
	}

	public static final void _wglUniform2f(UniformGL p1, float p2, float p3) {
		if (p1 != null)
			GL20.glUniform2f(p1.obj, p2, p3);
	}

	public static final void _wglUniform3f(UniformGL p1, float p2, float p3, float p4) {
		if (p1 != null)
			GL20.glUniform3f(p1.obj, p2, p3, p4);
	}

	public static final void _wglUniform4f(UniformGL p1, float p2, float p3, float p4, float p5) {
		if (p1 != null)
			GL20.glUniform4f(p1.obj, p2, p3, p4, p5);
	}

	public static final void _wglUniform1i(UniformGL p1, int p2) {
		if (p1 != null)
			GL20.glUniform1i(p1.obj, p2);
	}

	public static final void _wglUniform2i(UniformGL p1, int p2, int p3) {
		if (p1 != null)
			GL20.glUniform2i(p1.obj, p2, p3);
	}

	public static final void _wglUniform3i(UniformGL p1, int p2, int p3, int p4) {
		if (p1 != null)
			GL20.glUniform3i(p1.obj, p2, p3, p4);
	}

	public static final void _wglUniform4i(UniformGL p1, int p2, int p3, int p4, int p5) {
		if (p1 != null)
			GL20.glUniform4i(p1.obj, p2, p3, p4, p5);
	}

	private static final FloatBuffer matUpload = ByteBuffer.allocateDirect(16 << 2).order(ByteOrder.nativeOrder())
			.asFloatBuffer();

	public static final void _wglUniformMat2fv(UniformGL p1, float[] mat) {
		matUpload.clear();
		matUpload.put(mat);
		matUpload.flip();
		if (p1 != null)
			GL20.glUniformMatrix2(p1.obj, false, matUpload);
	}

	public static final void _wglUniformMat3fv(UniformGL p1, float[] mat) {
		matUpload.clear();
		matUpload.put(mat);
		matUpload.flip();
		if (p1 != null)
			GL20.glUniformMatrix3(p1.obj, false, matUpload);
	}

	public static final void _wglUniformMat4fv(UniformGL p1, float[] mat) {
		matUpload.clear();
		matUpload.put(mat);
		matUpload.flip();
		if (p1 != null)
			GL20.glUniformMatrix4(p1.obj, false, matUpload);
	}

	private static int currentProgram = 0;

	public static final void _wglUseProgram(ProgramGL p1) {
		int i = p1 == null ? 0 : p1.obj;
		if (i != currentProgram) {
			currentProgram = i;
			GL20.glUseProgram(i);
		}
	}

	public static final void _wglGetParameter(int p1, int size, int[] p3) {
		if (p1 == _wGL_VIEWPORT) {
			p3[0] = viewport[0];
			p3[1] = viewport[1];
			p3[2] = viewport[2];
			p3[3] = viewport[3];
		}
	}

	public static final void _wglPolygonOffset(float p1, float p2) {
		GL11.glPolygonOffset(p1, p2);
	}

	public static final void _wglVertexAttribPointer(int p1, int p2, int p3, boolean p4, int p5, int p6) {
		GL20.glVertexAttribPointer(p1, p2, p3, p4, p5, p6);
	}

	public static final void _wglBindFramebuffer(int p1, FramebufferGL p2) {
		GL30.glBindFramebuffer(p1, p2 == null ? 0 : p2.obj);
	}

	public static final void _wglDrawBuffer(int p1) {
		GL11.glDrawBuffer(p1);
	}

	public static final void _wglBlitFramebuffer(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9,
			int p10) {
		GL30.glBlitFramebuffer(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
	}

	public static final FramebufferGL _wglCreateFramebuffer() {
		return new FramebufferGL(GL30.glGenFramebuffers());
	}

	public static final void _wglDeleteFramebuffer(FramebufferGL p1) {
		GL30.glDeleteFramebuffers(p1.obj);
	}

	public static final void _wglFramebufferTexture2D(int p1, TextureGL p2) {
		GL30.glFramebufferTexture2D(GL30.GL_FRAMEBUFFER, p1, GL11.GL_TEXTURE_2D, p2.obj, 0);
	}

	public static final void _wglFramebufferTexture2D(int p1, TextureGL p2, int lvl) {
		GL30.glFramebufferTexture2D(GL30.GL_FRAMEBUFFER, p1, GL11.GL_TEXTURE_2D, p2.obj, lvl);
	}
	
	public static final RenderbufferGL _wglCreateRenderBuffer() {
		return new RenderbufferGL(GL30.glGenRenderbuffers());
	}

	public static final void _wglDeleteRenderbuffer(RenderbufferGL p1) {
		GL30.glDeleteRenderbuffers(p1.obj);
	}

	public static final void _wglBindRenderbuffer(RenderbufferGL p1) {
		GL30.glBindRenderbuffer(GL30.GL_RENDERBUFFER, p1 == null ? 0 : p1.obj);
	}

	public static final void _wglRenderbufferStorage(int p1, int p2, int p3) {
		GL30.glRenderbufferStorage(GL30.GL_RENDERBUFFER, p1, p2, p3);
	}

	public static final void _wglRenderbufferStorageMultisample(int p1, int p2, int p3, int p4) {
		GL30.glRenderbufferStorageMultisample(GL30.GL_RENDERBUFFER, p1, p2, p3, p4);
	}

	public static final void _wglFramebufferRenderbuffer(int p1, RenderbufferGL p2) {
		GL30.glFramebufferRenderbuffer(GL30.GL_FRAMEBUFFER, p1, GL30.GL_RENDERBUFFER, p2.obj);
	}

	public static final QueryGL _wglCreateQuery() {
		return new QueryGL(GL15.glGenQueries());
	}

	public static final void _wglBeginQuery(int p1, QueryGL p2) {
		GL15.glBeginQuery(p1, p2.obj);
	}

	public static final void _wglEndQuery(int p1) {
		GL15.glEndQuery(p1);
	}

	public static final void _wglDeleteQuery(QueryGL p1) {
		GL15.glDeleteQueries(p1.obj);
	}

	public static final int _wglGetQueryObjecti(QueryGL p1, int p2) {
		return GL15.glGetQueryObjecti(p1.obj, p2);
	}

	public static final void _wglLineWidth(float p1) {
		GL11.glLineWidth(p1);
	}

	public static final int _wglGetTexParameteri(int p1) {
		return GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, p1);
	}

	public static final float _wglGetTexParameterf(int p1) {
		return GL11.glGetTexParameterf(GL11.GL_TEXTURE_2D, p1);
	}

	public static final int _wglGetAttribLocation(ProgramGL p1, String p2) {
		return GL20.glGetAttribLocation(p1.obj, p2);
	}
	
	public static final void _wglBlendFuncSeparate(int p1, int p2, int p3, int p4) {
		GL14.glBlendFuncSeparate(p1, p2, p3, p4);
	}
	
	public static final void _wglPixelStorei(int p1, int p2) {
		GL11.glPixelStorei(p1, p2);
	}
	
	public static final EaglerImage loadPNG(byte[] data) {
		try {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(data));
			int[] pxls = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
			return new EaglerImage(img.getWidth(), img.getHeight(), pxls, true);
		} catch (IOException e) {
			System.err.println("Could not load PNG file:");
			e.printStackTrace();
			return null;
		}
	}

	// =======================================================================================
	// =======================================================================================
	// =======================================================================================
	// =======================================================================================
	// =======================================================================================

	private static Canvas daCanvas = null;
	private static Frame eagler = null;
	
	private static SoundSystem ss = null;

	public static final void initializeContext() {
		daCanvas = new Canvas();
		eagler = new Frame();
		eagler.setTitle("Alpha v1.2.6");
		eagler.setBackground(Color.BLACK);
		JPanel var16 = new JPanel();
		eagler.setLayout(new BorderLayout());
		var16.setPreferredSize(new Dimension(854, 480));
		eagler.add(var16, "Center");
		eagler.pack();
		eagler.setLocationRelativeTo((Component) null);
		eagler.setVisible(true);
		eagler.addWindowListener(new GameWindowListener());
		eagler.removeAll();
		eagler.setLayout(new BorderLayout());
		eagler.add(daCanvas, "Center");
		eagler.validate();
		eagler.setVisible(true);

		try {
			ContextAttribs contextAtrributes = new ContextAttribs(3, 2).withForwardCompatible(true)
					.withProfileCore(true).withDebug(true);
			Display.setParent(daCanvas);
			Display.create((new PixelFormat()).withDepthBits(24), contextAtrributes);
		} catch (LWJGLException var5) {
			var5.printStackTrace();

			try {
				Thread.sleep(1000L);
			} catch (InterruptedException var4) {
				;
			}

			try {
				Display.create();
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}

		// if(!_wisWebGL()) {
		// GL30.glBindVertexArray(GL30.glGenVertexArrays());
		// }

		try {
			Mouse.create();
			Keyboard.create();
		} catch (LWJGLException var5) {
			var5.printStackTrace();
		}

		if (useEPKTest) {
			try {
				InputStream stream = new FileInputStream(new File("out.epk"));
				byte[] targetArray = new byte[stream.available()];
				stream.read(targetArray);
				stream.close();
				AssetRepository.install(targetArray);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Display.setTitle("eaglercraft desktop runtime");
		System.out.println("LWJGL Version: " + Sys.getVersion());

		_wGL_ANY_SAMPLES_PASSED = ARBOcclusionQuery2.GL_ANY_SAMPLES_PASSED;
		_wGL_TEXTURE_MAX_ANISOTROPY = EXTTextureFilterAnisotropic.GL_TEXTURE_MAX_ANISOTROPY_EXT;

		GL11.glEnable(ARBDebugOutput.GL_DEBUG_OUTPUT_SYNCHRONOUS_ARB);
		ARBDebugOutput.glDebugMessageCallbackARB(new ARBDebugOutputCallback(new ARBDebugOutputCallback.Handler() {

			@Override
			public void handleMessage(int arg0, int arg1, int arg2, int arg3, String arg4) {
				if (arg3 == ARBDebugOutput.GL_DEBUG_SEVERITY_MEDIUM_ARB
						|| arg3 == ARBDebugOutput.GL_DEBUG_SEVERITY_HIGH_ARB) {
					StringBuilder b = new StringBuilder();
					b.append("[KHR DEBUG #");
					b.append(arg2);
					b.append("] ");
					switch (arg0) {
					case ARBDebugOutput.GL_DEBUG_SOURCE_API_ARB:
						b.append("[API - ");
						break;
					case ARBDebugOutput.GL_DEBUG_SOURCE_APPLICATION_ARB:
						b.append("[APPLICATION - ");
						break;
					default:
					case ARBDebugOutput.GL_DEBUG_SOURCE_OTHER_ARB:
						b.append("[OTHER - ");
						break;
					case ARBDebugOutput.GL_DEBUG_SOURCE_SHADER_COMPILER_ARB:
						b.append("[SHADER COMPILER - ");
						break;
					case ARBDebugOutput.GL_DEBUG_SOURCE_THIRD_PARTY_ARB:
						b.append("[THIRD PARTY - ");
						break;
					}
					switch (arg1) {
					case ARBDebugOutput.GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB:
						b.append("DEPRECATED BEHAVIOR] ");
						break;
					case ARBDebugOutput.GL_DEBUG_TYPE_ERROR_ARB:
						b.append("ERROR] ");
						break;
					default:
					case ARBDebugOutput.GL_DEBUG_TYPE_OTHER_ARB:
						b.append("OTHER] ");
						break;
					case ARBDebugOutput.GL_DEBUG_TYPE_PERFORMANCE_ARB:
						b.append("PERFORMANCE] ");
						break;
					case ARBDebugOutput.GL_DEBUG_TYPE_PORTABILITY_ARB:
						b.append("PORTABILITY] ");
						break;
					case ARBDebugOutput.GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB:
						b.append("UNDEFINED BEHAVIOR] ");
						break;
					}
					switch (arg3) {
					default:
					case ARBDebugOutput.GL_DEBUG_SEVERITY_LOW_ARB:
						b.append("[LOW Severity] ");
						break;
					case ARBDebugOutput.GL_DEBUG_SEVERITY_MEDIUM_ARB:
						b.append("[MEDIUM Severity] ");
						break;
					case ARBDebugOutput.GL_DEBUG_SEVERITY_HIGH_ARB:
						b.append("[SEVERE] ");
						break;
					}
					b.append(arg4);
					System.err.println(b.toString());
					if (arg3 == ARBDebugOutput.GL_DEBUG_SEVERITY_HIGH_ARB) {
						throw new RuntimeException("GL_DEBUG_SEVERITY_HIGH_ARB was thrown");
					}
				}
			}

		}));
		
		try {
			SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
			SoundSystemConfig.setCodec("mp3", CodecJLayerMP3.class);
			ss = new SoundSystem();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public static String forcedUser = null;
	public static String forcedServer = null;
	public static boolean joinServerOnLaunch = false;

	public static final void destroyContext() {
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				eagler.dispose();
			}
		});
		if (ss != null) {
			ss.cleanup();
		}
		AL.destroy();
	}

	public static final boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().contains("windows");
	}

	public static final boolean mouseNext() {
		return Mouse.next();
	}

	public static final int mouseGetEventButton() {
		return Mouse.getEventButton();
	}

	public static final boolean mouseGetEventButtonState() {
		return Mouse.getEventButtonState();
	}

	public static final boolean mouseIsButtonDown(int p1) {
		return Mouse.isButtonDown(p1);
	}

	public static final int mouseGetEventDWheel() {
		return Mouse.getDWheel();
	}

	public static final void mouseSetCursorPosition(int x, int y) {
		Mouse.setCursorPosition(x, y);
	}

	public static final void mouseSetGrabbed(boolean grabbed) {
		if(Mouse.isGrabbed() != grabbed) {
			Mouse.setGrabbed(grabbed);
		}
	}
	
	public static final boolean isPointerLocked() {
		return Mouse.isGrabbed();
	}
	
	public static final boolean isPointerLocked2() {
		return Mouse.isGrabbed();
	}

	public static final int mouseGetDX() {
		return Mouse.getDX();
	}

	public static final int mouseGetDY() {
		return Mouse.getDY();
	}

	public static final int mouseGetX() {
		return Mouse.getX();
	}

	public static final int mouseGetY() {
		return Mouse.getY();
	}

	public static final int mouseGetEventX() {
		return Mouse.getEventX();
	}

	public static final int mouseGetEventY() {
		return Mouse.getEventY();
	}

	public static final boolean keysNext() {
		return Keyboard.next();
	}

	public static final int getEventKey() {
		return Keyboard.getEventKey();
	}

	public static final char getEventChar() {
		return Keyboard.getEventCharacter();
	}

	public static final boolean getEventKeyState() {
		return Keyboard.getEventKeyState();
	}

	public static final boolean isKeyDown(int p1) {
		return Keyboard.isKeyDown(p1);
	}

	public static final boolean isFunctionKeyDown(boolean mod, int p1) {
		return Keyboard.getEventKey() == p1 || (mod && p1 >= Keyboard.KEY_F1 && p1 <= Keyboard.KEY_F9 && Keyboard.getEventKey() == (Keyboard.KEY_1 + (p1 - Keyboard.KEY_F1)));
	}

	public static final boolean isFunctionKeyDown(int mod, int p1) {
		return Keyboard.getEventKey() == p1 || (Keyboard.isKeyDown(mod) && p1 >= Keyboard.KEY_F1 && p1 <= Keyboard.KEY_F9 &
				Keyboard.getEventKey() == (Keyboard.KEY_1 + (p1 - Keyboard.KEY_F1)));
	}

	public static final boolean isFunctionKeyHeldDown(int mod, int p1) {
		return Keyboard.isKeyDown(p1) || (Keyboard.isKeyDown(mod) && p1 >= Keyboard.KEY_F1 && p1 <= Keyboard.KEY_F9 &
				Keyboard.isKeyDown(Keyboard.KEY_1 + (p1 - Keyboard.KEY_F1)));
	}

	public static final String getKeyName(int p1) {
		return Keyboard.getKeyName(p1);
	}

	public static final void setFullscreen(boolean p1) {
		try {
			Display.setFullscreen(p1);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public static final boolean shouldShutdown() {
		return Display.isCloseRequested();
	}

	public static final void updateDisplay() {
		Display.update();
	}

	public static final void setVSyncEnabled(boolean p1) {
		Display.setVSyncEnabled(p1);
	}

	public static final void enableRepeatEvents(boolean b) {
		Keyboard.enableRepeatEvents(b);
	}

	public static final boolean isFocused() {
		return Display.isActive();
	}

	public static final int getScreenWidth() {
		return Display.getDisplayMode().getWidth();
	}

	public static final int getScreenHeight() {
		return Display.getDisplayMode().getHeight();
	}

	public static final int getCanvasWidth() {
		return daCanvas.getWidth();
	}

	public static final int getCanvasHeight() {
		return daCanvas.getHeight();
	}

	public static final void setDisplaySize(int x, int y) {
		try {
			Display.setDisplayMode(new DisplayMode(x, y));
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public static final void syncDisplay(int performanceToFps) {
		Display.sync(performanceToFps);
	}
	
	private static final Set<String> rateLimitedAddresses = new HashSet();
	private static final Set<String> blockedAddresses = new HashSet();

	private static WebSocketClient clientSocket = null;
	private static final Object socketSync = new Object();

	private static LinkedList<byte[]> readPackets = new LinkedList();

	private static class EaglerSocketClient extends WebSocketClient {

		private Exception currentException = null;
		private boolean wasAbleToConnect = false;
		private String serverUriString;
		private boolean socketIsAlive = false;

		public EaglerSocketClient(URI serverUri, String str) throws IOException, InterruptedException {
			super(serverUri);
			this.setTcpNoDelay(true);
			this.setConnectionLostTimeout(5);
			System.out.println("[ws] connecting to " + serverUri.toString());
			rateLimitStatus = null;
			if (!this.connectBlocking(5, TimeUnit.SECONDS)) {
				synchronized (socketSync) {
					if (rateLimitStatus == null) {
						if (blockedAddresses.contains(str)) {
							rateLimitStatus = RateLimit.BLOCKED;
						} else if (rateLimitedAddresses.contains(str)) {
							rateLimitStatus = RateLimit.FAILED_POSSIBLY_LOCKED;
						} else {
							rateLimitStatus = RateLimit.FAILED;
						}
					}
				}
				throw new IOException("could not connect socket", currentException);
			}
			serverUriString = str;
		}

		@Override
		public void onClose(int arg0, String arg1, boolean arg2) {
			synchronized (socketSync) {
				readPackets.clear();
				System.out.println("[ws] disconnecting - " + currentException);
				currentException = null;
				if (!wasAbleToConnect && rateLimitStatus == null) {
					if (blockedAddresses.contains(serverUriString)) {
						rateLimitStatus = RateLimit.LOCKED;
					} else if (rateLimitedAddresses.contains(serverUriString)) {
						rateLimitStatus = RateLimit.FAILED_POSSIBLY_LOCKED;
					} else {
						rateLimitStatus = RateLimit.FAILED;
					}
				} else if (!socketIsAlive && (blockedAddresses.contains(serverUriString)
						|| rateLimitedAddresses.contains(serverUriString))) {
					rateLimitStatus = RateLimit.LOCKED;
				}
			}
		}

		@Override
		public void onError(Exception arg0) {
			currentException = arg0;
		}

		@Override
		public void onMessage(String arg0) {
			wasAbleToConnect = true;
			synchronized (socketSync) {
				if (arg0.equalsIgnoreCase("BLOCKED")) {
					rateLimitedAddresses.add(serverUriString);
					if (rateLimitStatus == null) {
						rateLimitStatus = RateLimit.BLOCKED;
					}
				} else if (arg0.equalsIgnoreCase("LOCKED")) {
					blockedAddresses.add(serverUriString);
					rateLimitedAddresses.add(serverUriString);
					if (rateLimitStatus == null) {
						rateLimitStatus = RateLimit.NOW_LOCKED;
					}
				}
			}
			this.close();
			currentException = null;
		}

		@Override
		public void onMessage(ByteBuffer arg0) {
			wasAbleToConnect = true;
			synchronized (socketSync) {
				readPackets.add(arg0.array());
			}
			currentException = null;
		}

		@Override
		public void onOpen(ServerHandshake arg0) {
			System.out.println("[ws] connected.");
		}

	}

	public static final boolean startConnection(String uri) {
		if (clientSocket != null) {
			clientSocket.close();
		}
		rateLimitStatus = null;
		try {
			clientSocket = new EaglerSocketClient(new URI(uri), uri);
			return true;
		} catch (InterruptedException e) {
			clientSocket = null;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static final void endConnection() {
		synchronized (socketSync) {
			if (clientSocket.isOpen()) {
				clientSocket.close();
			}
			clientSocket = null;
			readPackets.clear();
		}
	}

	public static final boolean connectionOpen() {
		return clientSocket != null && clientSocket.isOpen();
	}

	public static final void writePacket(byte[] packet) {
		if (clientSocket != null && clientSocket.isOpen()) {
			clientSocket.send(ByteBuffer.wrap(packet));
		}
	}

	public static final byte[] readPacket() {
		synchronized (socketSync) {
			if (!readPackets.isEmpty()) {
				return readPackets.remove(0);
			}
		}
		return null;
	}

	private static RateLimit rateLimitStatus = null;

	public static enum RateLimit {
		NONE, FAILED, BLOCKED, FAILED_POSSIBLY_LOCKED, LOCKED, NOW_LOCKED;
	}

	public static final RateLimit getRateLimitStatus() {
		RateLimit l = rateLimitStatus;
		rateLimitStatus = null;
		return l;
	}

	public static final void logRateLimit(String addr, RateLimit l) {
		synchronized (socketSync) {
			if (l == RateLimit.LOCKED) {
				blockedAddresses.add(addr);
			} else {
				rateLimitedAddresses.add(addr);
			}
		}
	}

	public static final RateLimit checkRateLimitHistory(String addr) {
		synchronized (socketSync) {
			if (blockedAddresses.contains(addr)) {
				return RateLimit.LOCKED;
			} else if (rateLimitedAddresses.contains(addr)) {
				return RateLimit.BLOCKED;
			} else {
				return RateLimit.NONE;
			}
		}
	}

	public static final byte[] loadLocalStorage(String key) {
		try {
			File f = new File("_eagstorage." + key + ".dat");
			byte[] b = new byte[(int) f.length()];
			FileInputStream s = new FileInputStream(f);
			s.read(b);
			s.close();
			return b;
		} catch (IOException e) {
			return null;
		}
	}

	public static final void saveLocalStorage(String key, byte[] data) {
		try {
			FileOutputStream f = new FileOutputStream(new File("_eagstorage." + key + ".dat"));
			f.write(data);
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final void openLink(String url) {
		try {
			Class var3 = Class.forName("java.awt.Desktop");
			Object var4 = var3.getMethod("getDesktop", new Class[0]).invoke((Object) null, new Object[0]);
			var3.getMethod("browse", new Class[] { URI.class }).invoke(var4, new Object[] { new URI(url) });
		} catch (Throwable var5) {
			var5.printStackTrace();
		}
	}

	private static volatile boolean fileChooserOpen = false;
	private static volatile boolean fileChooserHasResult = false;
	private static volatile FileChooserResult fileChooserResultObject = null;

	public static void displayFileChooser(final String mime, final String ext) {
		if(!fileChooserOpen) {
			fileChooserOpen = true;
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					runDisplayFileChooser(mime, ext);
				}
			});
		}
	}

	private static void runDisplayFileChooser(String mime, String ext) {
		try {
			JFileChooser fc = new FileChooserAlwaysOnTop((new File(".")).getAbsoluteFile());
			fc.setDialogTitle("select a file");
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setMultiSelectionEnabled(false);
			fc.setFileFilter(new FileFilterExt(ext));
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				if(f != null) {
					String name = f.getName();
					byte[] bytes = new byte[(int)f.length()];
					try(FileInputStream is = new FileInputStream(f)) {
						is.read(bytes);
					}
					fileChooserResultObject = new FileChooserResult(name, bytes);
				}else {
					fileChooserResultObject = null;
				}
			}
		}catch(Throwable t) {
			fileChooserResultObject = null;
		}
		fileChooserOpen = false;
		fileChooserHasResult = true;
	}

	private static class FileChooserAlwaysOnTop extends JFileChooser {
		
		private FileChooserAlwaysOnTop(File file) {
			super(file);
		}
		
		protected JDialog createDialog(Component parent) throws HeadlessException {
			JDialog dialog = super.createDialog(parent);
			dialog.setAlwaysOnTop(true);
			return dialog;
		}
		
	}

	private static class FileFilterExt extends FileFilter {

		private final String extension;

		private FileFilterExt(String ext) {
			extension = ext;
		}

		@Override
		public boolean accept(File f) {
			return f.isDirectory() || f.getName().endsWith("." + extension);
		}

		@Override
		public String getDescription() {
			return extension + " files";
		}

	}

	public static boolean fileChooserHasResult() {
		return fileChooserHasResult;
	}

	public static FileChooserResult getFileChooserResult() {
		fileChooserHasResult = false;
		FileChooserResult res = fileChooserResultObject;
		fileChooserResultObject = null;
		return res;
	}
	
	private static float soundX = 0f;
	private static float soundY = 0f;
	private static float soundZ = 0f;

	public static final void setListenerPos(float x, float y, float z, float vx, float vy, float vz, float pitch, float yaw) {
		soundX = x; soundY = y; soundZ = z;
		float var2 = MathHelper.cos(-yaw * 0.017453292F);
		float var3 = MathHelper.sin(-yaw * 0.017453292F);
		float var4 = -MathHelper.cos(pitch * 0.017453292F);
		float var5 = MathHelper.sin(pitch * 0.017453292F);
		ss.setListenerPosition(x, y, z);
		ss.setListenerOrientation(-var3 * var4, -var5, -var2 * var4, 0.0f, 1.0f, 0.0f);
		ss.setListenerVelocity(vx, vy, vz);
	}

	public static final void setPlaybackOffsetDelay(float f) {
		// nah
	}

	private static int playbackId = 0;

	public static final int beginPlayback(String fileName, float x, float y, float z, float volume, float pitch) {
		int id = ++playbackId;
		URL loc = null;
		if ((loc = getResourceURL(fileName)) != null) {
			String name = "sound_" + id;
			float var8 = 16.0F;
			if (volume > 1.0F) {
				var8 *= volume;
			}
			ss.newSource(false, name, loc, fileName, false, x, y, z, 2, var8);
			ss.setTemporary(name, true);
			ss.setPitch(name, pitch);
			ss.setVolume(name, volume);
			ss.play(name);
		} else {
			return -1;
		}
		return id;
	}

	public static final int beginPlaybackStatic(String fileName, float volume, float pitch) {
		int id = ++playbackId;
		URL loc = null;
		if ((loc = getResourceURL(fileName)) != null) {
			String name = "sound_" + id;
			ss.newSource(false, name, loc, fileName, false, soundX, soundY, soundZ, 0, 0f);
			ss.setTemporary(name, true);
			ss.setPitch(name, pitch);
			ss.setVolume(name, volume);
			ss.play(name);
		} else {
			return -1;
		}
		return id;
	}

	private static URL getResourceURL(String path) {
		try {
			File f = new File("resources", path);
			if (f.exists()) {
				return f.toURI().toURL();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static final void setPitch(int id, float pitch) {
		String name = "sound_" + id;
		if (ss.playing(name)) {
			ss.setPitch(name, pitch);
		}
	}

	public static final void setVolume(int id, float volume) {
		String name = "sound_" + id;
		if (ss.playing(name)) {
			ss.setVolume(name, volume);
		}
	}

	public static final void moveSound(int id, float x, float y, float z, float vx, float vy, float vz) {
		String name = "sound_" + id;
		if (ss.playing(name)) {
			ss.setPosition(name, x, y, z);
			ss.setVelocity(name, vx, vy, vz);
		}
	}

	public static final void endSound(int id) {
		String name = "sound_" + id;
		if (ss.playing(name)) {
			ss.stop(name);
		}
	}

	public static final boolean isPlaying(int id) {
		return ss.playing("sound_" + id);
	}

	public static final long maxMemory() {
		return Runtime.getRuntime().maxMemory();
	}

	public static final long totalMemory() {
		return Runtime.getRuntime().totalMemory();
	}

	public static final long freeMemory() {
		return Runtime.getRuntime().freeMemory();
	}

	public static final void exit() {
		Runtime.getRuntime().halt(0);
	}

	public static final int _wArrayByteLength(Object obj) {
		return ((IntBuffer) obj).remaining() * 4;
	}

	public static final Object _wCreateLowLevelIntBuffer(int len) {
		return ByteBuffer.allocateDirect(len * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
	}

	private static final IntBuffer appendbuffer = (IntBuffer) _wCreateLowLevelIntBuffer(525000);

	public static final void _wAppendLowLevelBuffer(Object arr) {
		if (appendbuffer.limit() != appendbuffer.capacity())
			appendbuffer.clear();
		IntBuffer a = (IntBuffer) arr;
		if (appendbuffer.remaining() >= a.remaining()) {
			appendbuffer.put(a);
		}
	}

	public static final Object _wGetLowLevelBuffersAppended() {
		appendbuffer.flip();
		return appendbuffer;
	}

	public static final String getUserAgent() {
		return System.getProperty("os.name");
	}

	public static final String getClipboard() {
		try {
			return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			return null;
		}
	}

	public static final void setClipboard(String str) {
		StringSelection selection = new StringSelection(str);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}

	public static final void saveScreenshot() {

	}

	private static String serverToJoinOnLaunch = null;

	public static final void setServerToJoinOnLaunch(String s) {
		serverToJoinOnLaunch = s;
	}

	public static final String getServerToJoinOnLaunch() {
		return serverToJoinOnLaunch;
	}
	
	private static final File filesystemBaseDirectory = new File("./filesystem");
	
	static {
		filesystemBaseDirectory.mkdirs();
	}
	
	// ======== Virtual Filesystem Functions =============
	
	public static final boolean fileExists(String path) {
		return (new File(filesystemBaseDirectory, stripPath(path))).isFile();
	}
	
	public static final boolean directoryExists(String path) {
		return (new File(filesystemBaseDirectory, stripPath(path))).isDirectory();
	}
	
	public static final boolean pathExists(String path) {
		return (new File(filesystemBaseDirectory, stripPath(path))).exists();
	}
	
	public static final void writeFile(String path, byte[] data) {
		try {
			File f = new File(filesystemBaseDirectory, stripPath(path));
			File p = f.getParentFile();
			if(p != null) {
				p.mkdirs();
			}
			FileOutputStream os = new FileOutputStream(f);
			os.write(data);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static final byte[] readFile(String path) {
		File f = new File(filesystemBaseDirectory, stripPath(path));
		if(!f.isFile()) {
			return null;
		}
		try {
			byte[] ret = new byte[(int)f.length()];
			FileInputStream in = new FileInputStream(f);
			in.read(ret);
			in.close();
			return ret;
		}catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static final long getLastModified(String path) {
		return (new File(filesystemBaseDirectory, stripPath(path))).lastModified();
	}
	
	public static final int getFileSize(String path) {
		return (int)(new File(filesystemBaseDirectory, stripPath(path))).length();
	}
	
	public static final void renameFile(String oldPath, String newPath) {
		File f1 = new File(filesystemBaseDirectory, stripPath(oldPath));
		File f2 = new File(filesystemBaseDirectory, stripPath(newPath));
		if(f1.exists()) {
			if(f2.exists()) {
				try {
					FileInputStream fs1 = new FileInputStream(f1);
					FileOutputStream fs2 = new FileOutputStream(f2);
					byte[] buffer = new byte[1024 * 64];
					int a;
					while((a = fs1.read(buffer)) > 0) {
						fs2.write(buffer, 0, a);
					}
					fs1.close();
					fs2.close();
					f1.delete();
				} catch (IOException e) {
					System.err.println("Copy from '" + oldPath + "' to '" + newPath + "' failed");
					e.printStackTrace();
				}
			}else {
				File p = f2.getParentFile();
				if(p != null) {
					p.mkdirs();
				}
				f1.renameTo(f2);
			}
		}
	}
	
	public static final void copyFile(String oldPath, String newPath) {
		try {
			File ff2 = new File(filesystemBaseDirectory, stripPath(newPath));
			File p = ff2.getParentFile();
			if(p != null) {
				p.mkdirs();
			}
			FileInputStream f1 = new FileInputStream(new File(filesystemBaseDirectory, stripPath(oldPath)));
			FileOutputStream f2 = new FileOutputStream(ff2);
			byte[] buffer = new byte[1024 * 64];
			int a;
			while((a = f1.read(buffer)) > 0) {
				f2.write(buffer, 0, a);
			}
			f1.close();
			f2.close();
		} catch (IOException e) {
			System.err.println("Copy from '" + oldPath + "' to '" + newPath + "' failed");
			e.printStackTrace();
		}
	}
	
	public static final void deleteFile(String path) {
		(new File(filesystemBaseDirectory, stripPath(path))).delete();
	}
	
	public static final Collection<FileEntry> listFiles(String path, boolean listDirs, boolean recursiveDirs) {
		path = stripPath(path);
		ArrayList<FileEntry> ret = new ArrayList<>();
		File f = new File(filesystemBaseDirectory, path);
		if(f.isFile()) {
			ret.add(new FileEntry(path, false, f.lastModified()));
		}else if(f.isDirectory()) {
			for(File ff : f.listFiles()) {
				if(ff.isDirectory()) {
					if(listDirs && !recursiveDirs) {
						ret.add(new FileEntry(path + "/" + ff.getName(), true, -1l));
					}
					if(recursiveDirs) {
						recursiveListing(path + "/" + ff.getName(), ff, ret, listDirs, recursiveDirs);
					}
				}else {
					ret.add(new FileEntry(path + "/" + ff.getName(), false, ff.lastModified()));
				}
			}
		}
		return ret;
	}
	
	private static void recursiveListing(String path, File f, Collection<FileEntry> lst, boolean listDirs, boolean recursiveDirs) {
		if(f.isFile()) {
			lst.add(new FileEntry(path, false, f.lastModified()));
		}else if(f.isDirectory()) {
			if(listDirs) {
				lst.add(new FileEntry(path, true, -1l));
			}
			if(recursiveDirs) {
				for(File ff : f.listFiles()) {
					recursiveListing(path + "/" + ff.getName(), ff, lst, listDirs, recursiveDirs);
				}
			}
		}
	}
	
	public static final Collection<FileEntry> listFilesAndDirectories(String path) {
		return listFiles(path, true, false);
	}
	
	public static final Collection<FileEntry> listFilesRecursive(String path) {
		return listFiles(path, false, true);
	}
	
	public static class FileEntry {
		
		public final String path;
		public final boolean isDirectory;
		public final long lastModified;
		
		protected FileEntry(String path, boolean isDirectory, long lastModified) {
			this.path = path;
			this.isDirectory = isDirectory;
			this.lastModified = lastModified;
		}
		
		public String getName() {
			int i = path.indexOf('/');
			if(i >= 0) {
				return path.substring(i + 1);
			}else {
				return path;
			}
		}
		
	}
	
	private static String stripPath(String str) {
		if(str.startsWith("/")) {
			str = str.substring(1);
		}
		if(str.endsWith("/")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
	
	public static final void downloadFile(String filename, byte[] data) {
		File downloadDir = new File("downloads");
		downloadDir.mkdirs();
		try {
			FileOutputStream out = new FileOutputStream(new File(downloadDir, filename));
			out.write(data);
			out.close();
			System.out.println("fake downloaded file '" + filename + "' to the debug directory");
		} catch (IOException e) {
			System.err.println("Failed to 'download' file: " + filename);
			e.printStackTrace();
		}
	}
	
	public static boolean isCompressed(byte[] b) {
		if(b == null || b.length < 2) {
			return false;
		}
		return (b[0] == (byte) 0x1F) && (b[1] == (byte) 0x8B);
	}
	
	public static boolean escapeKeyPressed() {
		return getEventKey() == 1;
	}

}