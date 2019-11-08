package P3;

import java.util.Scanner;

public class Action 
{
	
	/**�������Ϸ�������
	 * 
	 * @param ѡ��player
	 * @param ����piece
	 * @param λ��p
	 * @return �ɹ����÷���true�����򷵻�false.
	 */
	public boolean place(Player player , Piece piece , Position p) 
	{
		if(!p.isempty) //��λ���������ˡ�
		{
			System.out.println("There is already a piece in this position.");
			return false;
		}
		else if(!piece.getbelongs().equals(player.getname())) //�����Ӳ����ڸ�ѡ��
		{
			System.out.println("Piece does not belong to the player.");
			return false;
		}
		else if((piece.getpos().x!=-1) && (piece.getpos().y!=-1)) //��������λ�������ϡ�
		{
			System.out.println("The piece is already on the board.");
			return false;
		}
		else
		{
			piece.getpos().x = p.getpos().x;
			piece.getpos().y = p.getpos().y;
			p.isempty = false;
			p.reset(piece);
			return true;
		}
	}
	
}


class goAction extends Action
{
	// Abstraction function:
    // Nothing
    
    // Representation invariant:
    // Nothing
	
	/**չʾ��ǰ��ѡ�ֵ����
	 * 
	 * @param ѡ��player
	 */
	public void showsituation(goPlayer player) 
	{
		
		int i , n = 0;
		System.out.println(player.getname() + "'s situtation:");
		for(i = 0 ; i < player.getgoPicecs().length ; i++)
		{
			
			if((player.getgoPicecs()[i].getpos().x != -1) && (player.getgoPicecs()[i].getpos().y != -1) )
			{
				System.out.println(player.getgoPicecs()[i]);
				n++;
			}
		}
		System.out.println(player.getname() + " have " + n + " pieces");
		System.out.println();
		
	}
	
	@Override public boolean place(Player player , Piece piece , Position p) 
	{
		
		if((p.getpos().x > 18) || (p.getpos().y > 18)) //λ�ó������̷�Χ��
		{
			System.out.println("Out of board.");
			return false;
		}
		return super.place(player, piece, p);
		
	}
	
	/**��Χ����������������
	 * 
	 * @param ѡ��player
	 * @param λ��p
	 * @return �ɹ�����true,���򷵻�false.
	 */
	public boolean remove(Player player , Position p) 
	{
		if(p.isempty)
		{
			System.out.println("There is no  piece here.");
			return false;
		}
		else if(p.getpiece().getbelongs().equals(player.getname()))
		{
			System.out.println("Piece does not belong to the opponent.");
			return false;
		}
		else if((p.getpos().x > 18) || (p.getpos().y > 18))
		{
			System.out.println("Out of board.");
			return false;
		}
		else
		{
			p.getpiece().getpos().x = -1;
			p.getpiece().getpos().y = -1;
			p.reset(null);
			p.isempty = true;
			return true;
		}
	}
	
}

class chessAction extends Action
{
	// Abstraction function:
    // Nothing
    
    // Representation invariant:
    // Nothing
	
	/**չʾ��ǰ��ѡ�ֵ����
	 * 
	 * @param ѡ��player
	 */
	public void showsituation(ChessPlayer player) 
	{
		int i , n= 0;
		System.out.println(player.getname() + "'s situtation:");
		for(i = 0 ; i < player.getchessPieces().length ; i++)
		{
			
			if((player.getchessPieces()[i].getpos().x != -1) && (player.getchessPieces()[i].getpos().y != -1) )
			{
				System.out.println(player.getchessPieces()[i]);
				n++;
			}
		}
		System.out.println( player.getname() + " have " + n + " pieces");
		System.out.println();
	}
	

	
	/**�ƶ����ӣ��������ӡ�
	 * 
	 * @param ѡ��player
	 * @param ��λ��oldp
	 * @param ��λ��newp
	 * @return ʧ�ܷ���-1�����ƶ���δ���ӷ���0�����ӷ���1.
	 */
	public int  move(Player player , Position oldp , Position newp)
	{
		if((newp.getpos().x > 7) || (newp.getpos().y > 7)) //��λ�ó������̡�
		{
			System.out.println("Out of board.");
			return -1;
		}
		else if((oldp.getpos().x > 7) || (oldp.getpos().y > 7)) //��λ�ó������̡�
		{
			System.out.println("Out of board.");
			return -1;
		}
		else if((oldp.getpos().x == newp.getpos().x) && (oldp.getpos().y == newp.getpos().y)) //��λ������λ���غϡ�
		{
			System.out.println("Two identical positions.");
			return -1;
		}
		else if(oldp.isempty) //��λ���������ӡ�
		{
			System.out.println("There is no  piece here.");
			return -1;
		} 
		else if(!oldp.getpiece().getbelongs().equals(player.getname())) //��λ�������Ӳ����ڸ�ѡ�֡�
		{
			System.out.println("Piece does not belong to the player.");
			return -1;
		}
		
		else if((!newp.isempty) && (newp.getpiece().getbelongs().equals(player.getname()))) //�����Լ����Լ������ӡ�
		{
			System.out.println("You can't eat your own chess pieces.");
			return -1;
		}
		else if(!newp.isempty && (!(newp.getpiece().getbelongs().equals(player.getname()))))
		{
			System.out.println("Do you want to eat " + newp.getpiece().getbelongs() + "'s " +newp.getpiece().toString() + " ?");
			Scanner sc = new Scanner(System.in);
			String choice = sc.next();
			if(choice.equalsIgnoreCase("yes"))
			{
				//ȥ��Ŀ��λ�õ����ӡ�
				newp.getpiece().getpos().x = -1;
				newp.getpiece().getpos().y = -1;
				//����λ���ϵ����ӷŵ���λ���ϡ�
				oldp.getpiece().getpos().x = newp.getpos().x;
				oldp.getpiece().getpos().y = newp.getpos().y;
				newp.reset(oldp.getpiece());
				//ɾ����λ���ϵ����Ӻۼ���
				oldp.reset(null);
				oldp.isempty = true;
				return 1;
			}
			else 
			{
				System.out.println("You don't move.");
				return -1;
			}
		}
		else
		{
			newp.isempty = false;
			oldp.getpiece().getpos().x = newp.getpos().x;
			oldp.getpiece().getpos().y = newp.getpos().y;
			newp.reset(oldp.getpiece());
			oldp.reset(null);
			oldp.isempty = true;
			return 0;
		}
		
	}

	
	
}